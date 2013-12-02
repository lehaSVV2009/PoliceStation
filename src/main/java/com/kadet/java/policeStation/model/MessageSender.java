package com.kadet.java.policeStation.model;

import com.kadet.java.policeStation.util.MailProperties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Date: 01.12.13
 * Time: 22:35
 *
 * @author Кадет
 */
public class MessageSender {

    private class SMTPAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(MailProperties.EMAIL, MailProperties.PASSWORD);
        }
    }

    private Properties createEmailProperties () {
        Properties properties = new Properties();
        properties.put(MailProperties.MAIL_SMTP_USER,
                MailProperties.MAIL_SMTP_USER_VALUE);
        properties.put(MailProperties.MAIL_SMTP_HOST,
                MailProperties.MAIL_SMTP_HOST_VALUE);
        properties.put(MailProperties.MAIL_SMTP_PORT,
                MailProperties.MAIL_SMTP_PORT_VALUE);
        properties.put(MailProperties.MAIL_SMTP_STARTTLS_ENABLE,
                MailProperties.MAIL_SMTP_STARTTLS_ENABLE_VALUE);
        properties.put(MailProperties.MAIL_SMTP_DEBUG,
                MailProperties.MAIL_SMTP_DEBUG_VALUE);
        properties.put(MailProperties.MAIL_SMTP_AUTH,
                MailProperties.MAIL_SMTP_AUTH_VALUE);
        properties.put(MailProperties.MAIL_SMTP_SOCKET_FACTORY_PORT,
                MailProperties.MAIL_SMTP_AUTH_VALUE);
        properties.put(MailProperties.MAIL_SMTP_SOCKET_FACTORY_CLASS,
                MailProperties.MAIL_SMTP_SOCKET_FACTORY_CLASS_VALUE);
        properties.put(MailProperties.MAIL_SMTP_SOCKET_FACTORY_FALLBACK,
                MailProperties.MAIL_SMTP_SOCKET_FACTORY_FALLBACK_VALUE);
        return properties;
    }

    private MimeMessage createMimeMessage (String message, String toEmail, String topic, Session session) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setText(message);
        mimeMessage.setSubject(topic);
        mimeMessage.setFrom(
                new InternetAddress(MailProperties.EMAIL));
        mimeMessage.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(toEmail));
        return mimeMessage;
    }

    public boolean sendMessageToEmail(String message, String toEmail, String topic) {

        Session session = Session.getInstance(
                createEmailProperties(),
                new SMTPAuthenticator()
        );
        session.setDebug(true);
        try {

            MimeMessage mimeMessage
                    = createMimeMessage(message, toEmail, topic, session);
            Transport transport = session.getTransport("smtps");
            transport.connect(
                    MailProperties.HOST,
                    465,
                    MailProperties.USERNAME,
                    MailProperties.PASSWORD
            );
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
