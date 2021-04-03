package utilities;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;

public class EmailUtil {
    public static final String EMAIL = "mhbughdadi@gmail.com";
    public static final String PASSWORD = "wqqbkoigksoqyfwu";
    /**
     * sendMail  sends an email for the current user .
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     * @return
     */
    private static MimeMessage createMessage(Session session, String toEmail, String subject, String body){
        MimeMessage msg = new MimeMessage(session);
        try {

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("support@Ludus.com", "Ludus.com"));
            msg.setReplyTo(InternetAddress.parse("mhbughdadi@google.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.addRecipients(MimeMessage.RecipientType.BCC, InternetAddress.parse(toEmail,false));
            System.out.println("Message is ready");
            msg.saveChanges();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return msg ;
    }

    /**
     *this method to create session object which initialize the operation of sending messages
     * @param from
     * @param toEmail
     * @param password
     * @return
     */
    private static Session initSession(String from, String toEmail, String password){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        return  Session.getInstance(props, auth);


    }

    /**
     * this method to send the email itself on the network to the mail server
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(String toEmail, String subject, String body) throws IllegalArgumentException {
        if(toEmail==null||toEmail.trim().equals("")){
            throw new IllegalArgumentException("email should be not null or empty string ");
        }
        Session session = initSession(EMAIL,toEmail,PASSWORD);
        MimeMessage message = createMessage(session,toEmail,subject,body);
        try {
            Transport . send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

}
