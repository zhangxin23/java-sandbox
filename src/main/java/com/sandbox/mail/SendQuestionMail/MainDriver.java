package com.sandbox.mail.SendQuestionMail;

import java.util.Arrays;
import java.util.List;

/**
 * Author: zhangxin
 * Date:   16-1-27
 */
public class MainDriver {

    public static void main(String [] args) {
        List<String> emailList = Arrays.asList("test@example.com");
        emailList.parallelStream()
                 .forEach(item->{
                     System.out.println("Sending " + item + " ...");
                     MailSender.sendMail(item);
                     });
    }
}
