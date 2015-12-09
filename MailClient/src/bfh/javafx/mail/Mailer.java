package bfh.javafx.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Extremely simple helper class to send Emails using BFH's smtp server. 
 */
public class Mailer {

	public static final String HOST = "hermes.bfh.ch";
	public static final String PORT = "587";
	
	
	/**
	 * Sends an email using BFH's smtp server hermes.bfh.ch.
	 * 
	 * @param login The login (eg. 'abc2')
	 * @param password The password
	 * @param fromEmail The from email must match with the login (eg. 'claus.amsberger@bfh.ch')
	 * @param toEmail The to email (eg. 'samichlaus@wald.ch')
	 * @param subject The subject of the message.
	 * @param message The message
	 * @throws MessagingException
	 */
	public static void send(final String login, final String password, final String fromEmail, final String toEmail, final String subject, final String message)
			throws MessagingException {

		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(login, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		MimeMessage msg = new MimeMessage(session);

		msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		msg.addHeader("Content-Transfer-Encoding", "8bit");

		msg.setFrom(new InternetAddress(fromEmail));

		msg.setSubject(subject, "UTF-8");
		msg.setText(message, "UTF-8");
		msg.setSentDate(new Date());

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		Transport.send(msg);
	}
}
