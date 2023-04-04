package me.minikuma._02_structual_patterns._10_facade._02_after;

public class Client {
    public static void main(String[] args) {

        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("host");
        emailSettings.setAuth("auth");
        emailSettings.setPasword("password");
        emailSettings.setEnable("enable");
        emailSettings.setPort("port");

        EmailSender emailSender = new EmailSender(emailSettings);

        EmailMessage message = new EmailMessage();
        message.setFrom("from");
        message.setSubject("subject");
        message.setText("text");

        emailSender.sendingEmail(message);
    }
}
