package mum.ea.blog.reciever;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import mum.ea.blog.domain.Contact;
import mum.ea.blog.service.EmailService;

/**
 * 
 * @author Toan Quach
 *
 */
public class ContactListener implements MessageListener {

	private EmailService emailService;

	private static final Logger LOGGER = Logger.getLogger(ContactListener.class);

	/**
	 * @param emailService
	 *            the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public synchronized void onMessage(Message message) {
		ObjectMessage obj = (ObjectMessage) message;
		try {
			Contact contact = (Contact) obj.getObject();
			LOGGER.info("Recieving contact information with: email: " + contact.getEmail() + " and message: "
					+ contact.getMessage());
			// System.out.println("Recieving contact information with: email: "
			// + contact.getEmail() + " and message: "
			// + contact.getMessage());
			this.sendEmail(contact);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void sendEmail(Contact contact) {
		emailService.sendEmail(contact);
	}
}
