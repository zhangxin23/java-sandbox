package com.sandbox.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;

/**
 * 发送邮件给多个接收者、抄送邮件
 */
public class MultiMailsender {
    /**
     * 发送多接收者类型邮件的基本信息
     */
    public static class MultiMailSenderInfo extends MailSenderInfo {
        // 邮件的接收者，可以有多个
        private String[] receivers;

        // 邮件的抄送者，可以有多个
        private String[] ccs;

        public String[] getCcs() {
            return ccs;
        }

        public void setCcs(String[] ccs) {
            this.ccs = ccs;
        }

        public String[] getReceivers() {
            return receivers;
        }

        public void setReceivers(String[] receivers) {
            this.receivers = receivers;
        }
    }

    /**
     * 发送邮件给多个接收者
     * @param mailInfo    带发送邮件的信息
     * @return
     */
    public static boolean sendMailtoMultiReceiver(MultiMailSenderInfo mailInfo) {
        MyAuthenticator authenticator = null;
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }

        Session sendMailSession = Session.getInstance(mailInfo.getProperties(), authenticator);
        try {
            Message mailMessage = new MimeMessage(sendMailSession);

            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);

            // 创建邮件的接收者地址，并设置到邮件消息中
            Address[] tos = null;
            String[] receivers = mailInfo.getReceivers();
            if (receivers != null){
                // 为每个邮件接收者创建一个地址
                tos = new InternetAddress[receivers.length + 1];
                tos[0] = new InternetAddress(mailInfo.getToAddress());
                for (int i=0; i<receivers.length; i++){
                    tos[i+1] = new InternetAddress(receivers[i]);
                }
            } else {
                tos = new InternetAddress[1];
                tos[0] = new InternetAddress(mailInfo.getToAddress());
            }

            // 将所有接收者地址都添加到邮件接收者属性中
            mailMessage.setRecipients(Message.RecipientType.TO, tos);
            mailMessage.setSubject(mailInfo.getSubject());
            mailMessage.setSentDate(new Date());

            // 设置邮件内容
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getContent(), "text/html; charset=UTF-8");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);

            // 发送邮件
            Transport.send(mailMessage);

            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 发送带抄送的邮件
     * @param mailInfo    待发送邮件的消息
     * @return
     */
    public static boolean sendMailtoMultiCC(MultiMailSenderInfo mailInfo){
        MyAuthenticator authenticator = null;
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        Session sendMailSession = Session.getInstance(mailInfo.getProperties(), authenticator);
        try {
            Message mailMessage = new MimeMessage(sendMailSession);

            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);

            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);

            // 获取抄送者信息
            String[] ccs = mailInfo.getCcs();
            if (ccs != null){
                // 为每个邮件接收者创建一个地址
                Address[] ccAdresses = new InternetAddress[ccs.length];
                for (int i=0; i<ccs.length; i++){
                    ccAdresses[i] = new InternetAddress(ccs[i]);
                }

                // 将抄送者信息设置到邮件信息中，注意类型为Message.RecipientType.CC
                mailMessage.setRecipients(Message.RecipientType.CC, ccAdresses);
            }

            mailMessage.setSubject(mailInfo.getSubject());
            mailMessage.setSentDate(new Date());

            // 设置邮件内容
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getContent(), "text/html; charset=UTF-8");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);

            // 发送邮件
            Transport.send(mailMessage);

            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String content = "<html>\n" +
                "<body>\n" +
                "<h2>freemarker</h2>\n" +
                "\n" +
                "<div>\n" +
                "    <table>\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <th>名字</th>\n" +
                "            <th>年龄</th>\n" +
                "            <th>国家</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <td>two</td>\n" +
                "            <td>11</td>\n" +
                "            <td>china</td>\n" +
                "        </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n" +
                "\n" +
                "<a href=\"http://www.baidu.com\"/>http://www.baidu.com</a>" +
                "</body>\n" +
                "</html>";

        // 创建邮件信息
        MultiMailSenderInfo mailInfo = new MultiMailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("");
        mailInfo.setPassword("");
        mailInfo.setFromAddress("");
        mailInfo.setToAddress("");
        mailInfo.setSubject("");
        mailInfo.setContent(content);

        String[] receivers = new String[]{""};
        String[] ccs = receivers;
        mailInfo.setReceivers(receivers);
        mailInfo.setCcs(ccs);

        MultiMailsender.sendMailtoMultiReceiver(mailInfo);
        //MultiMailsender.sendMailtoMultiCC(mailInfo);

        System.out.println("Send Email Successful.");
    }
}
