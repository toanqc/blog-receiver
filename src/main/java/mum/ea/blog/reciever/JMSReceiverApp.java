package mum.ea.blog.reciever;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Toan Quach
 *
 */
public class JMSReceiverApp {
	private static final Logger LOGGER = Logger.getLogger(JMSReceiverApp.class);

	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		LOGGER.info("JMS receiver is running ...");
	}
}
