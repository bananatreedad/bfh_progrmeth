package ch.bnntd.pgmmtd.mailclient;

import java.io.IOException;

import javax.mail.MessagingException;

import bfh.javafx.mail.Mailer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MailClientController {

	@FXML
	private TextField tf_emailTo, tf_emailFrom, tf_subject, tf_login;

	@FXML
	private PasswordField pf_password;

	@FXML
	private TextArea ta_message;

	@FXML
	private Button btn_send;

	@FXML
	private void btn_sendOnAction() throws IOException {
		boolean mailSuccess = false;
		String errorMessage = "";
		try {
			

			Mailer.send(tf_login.getText(), pf_password.getText(), tf_emailFrom.getText(), tf_emailTo.getText(),
					tf_subject.getText(), ta_message.getText());
			
			mailSuccess = true;
		} catch (MessagingException e) {
			errorMessage = e.getMessage();
		}
		
		new SendingMailStage(mailSuccess, errorMessage);

	}
}
