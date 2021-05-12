package by.jwd.restaurant.service.impl;

import by.jwd.restaurant.service.EmailService;
import by.jwd.restaurant.service.exception.ServiceException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl  implements EmailService {
    private final static String USER_NAME = "cinemacourseworkstar@gmail.com";
    private final static String PASSWORD = "Gw225om_11291625";

    @Override
    public void mail(String mail, String password) throws ServiceException {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { mail };
        String subject = "Востановление данных";
        String nbody = "jtry";
        String body = "Данные для восстановления доступа к системе ресторана\nВаш пароль: " + password;

        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) throws ServiceException {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {

            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");

            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ae) {
            throw new ServiceException("send email exception", ae);
        }
    }

}
