package me.minikuma._02_structual_patterns._10_facade._02_after;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private final EmailSettings emailSettings;

    public EmailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }

    public void sendingEmail(EmailMessage emailMessage) {
        // SMTP 서버
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", emailSettings.getHost());
        properties.setProperty("mail.smtp.port", emailSettings.getPort());
        properties.setProperty("mail.smtp.auth", emailSettings.getAuth());
        properties.setProperty("mail.smtp.ssl.enable", emailSettings.getEnable());
        properties.setProperty("mail.smtp.ssl.trust", emailSettings.getTrust());

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSettings.getUser(), emailSettings.getPasword());
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSettings.getUser()));
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(emailMessage.getTo())));

            // 주제
            message.setSubject(emailMessage.getSubject());

            // 본문
            message.setText(emailMessage.getText());

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
