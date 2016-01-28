package com.sandbox.mail.SendQuestionMail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.File;

/**
 * Author: zhangxin
 * Date:   16-1-26
 */
public class MailSender {

    private static String content = "<html>\n" +
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

    private static String EMAIL_HEAD_bak ="<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"format-detection\" content=\"telephone=no\"/>\n" +
            "    <meta name=\"format-detection\" content=\"address=no\"/>\n" +
            "    <meta name=\"viewport\"\n" +
            "          content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=no\"/>\n" +
            "    <meta content=\"yes\" name=\"apple-mobile-web-app-capable\"/>\n" +
            "</head>\n" +
            "<body style=\"background: #fff; margin:20px 0;\">\n" +
            "<!--[if (gte mso 9)|(IE)]>\n" +
            "<table width=\"800\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
            "    <tr>\n" +
            "        <td><![endif]-->\n" +
            "<div style=\"width: 94%;max-width:800px;border: 3px solid #ebebeb;margin: 0 auto;font-family: '微软雅黑', 'Helvetica Neue', Helvetica, STHeiTi, sans-serif;\">\n" +
            "\n" +
            "        <div style=\"display: block;width: 100%;margin-bottom: 25px;\">\n" +
            "            <img src=\"cid:$P_IMG_BANNER\" style=\"display: inline-block;width: 100%;\">\n" +
            "        </div>";


    private static String EMAIL_FOOT_bak="<div style=\"height: 90px;\"></div>\n" +
            "</div>\n" +
            "<!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></body>\n" +
            "</html>";

    private static final String EMAIL_HEAD = "<html>\n" +
            " <head>\n" +
            "  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\n" +
            "  <style>\n" +
            "    body { line-height: 1.5; }\n" +
            "    blockquote { margin-top: 0px; margin-bottom: 0px; margin-left: 0.5em; }\n" +
            "    p { margin-top: 0px; margin-bottom:0px; }\n" +
            "    body { font-size: 10.5pt; font-family: 'Microsoft YaHei UI'; color: rgb(0, 0, 0); line-height: 1.5; }\n" +
            "  </style> \n" +
            " </head>\n" +
            " <body>\n" +
            "  <blockquote>\n" +
            "   <div>";

    private static final String EMAIL_FOOT = "   </div>\n" +
            "  </blockquote> \n" +
            " </body>\n" +
            "</html>";

    /**
     * 发送内嵌图片的HTML邮件
     * */
    public static void sendMail(String emailAddr) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("host.addr");
            email.setSmtpPort(587);
            email.setStartTLSEnabled(true);
            email.setCharset("UTF-8");

            email.setFrom("test@example.com");
            email.setAuthentication("", "");

            email.addHeader("X-WPSMAIL-UA", "Questionnaire Survey");

            email.setSubject("subject");
            email.addTo(emailAddr);

            String first_pic = email.embed(new File("/your/path"));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(EMAIL_HEAD);
            stringBuffer.append("<div><img src=\"cid:" + first_pic + "\" border=\"0\"></div>");
            stringBuffer.append("your txt message");
            String second_pic = email.embed(new File("/your/path"));
            stringBuffer.append("<div><img src=\"cid:" + second_pic + "\" border=\"0\"></div>");
            stringBuffer.append(EMAIL_FOOT);
            email.setHtmlMsg(stringBuffer.toString());
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String ... args) {
        MailSender.sendMail("test@example.com");
    }
}
