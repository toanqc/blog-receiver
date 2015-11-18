package mum.ea.blog.service.impl;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import mum.ea.blog.domain.Contact;
import mum.ea.blog.service.EmailService;

/**
 * 
 * @author qct
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private MailSender mailSender;

	/**
	 * @param mailSender
	 *            the mailSender to set
	 */
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmail(Contact contact) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(contact.getEmail());
		message.setTo("toanqc@gmail.com");
		message.setSubject(contact.getTitle());
		message.setText(contact.getMessage());

		mailSender.send(message);
	}

}
