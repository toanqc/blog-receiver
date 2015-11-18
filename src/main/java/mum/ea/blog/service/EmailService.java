package mum.ea.blog.service;

import mum.ea.blog.domain.Contact;

/**
 * 
 * @author qct
 *
 */
public interface EmailService {

	/**
	 * 
	 * @param contact
	 */
	public void sendEmail(Contact contact);
}
