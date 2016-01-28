package com.sandbox.mail.SendQuestionMail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: zhangxin
 * Date:   16-1-27
 */
public class FileReaderUtil {

    private final static String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private final static Pattern regex = Pattern.compile(check);

    public boolean checkEmail(String email) {
        boolean isValid = false;
        try{
            Matcher matcher = regex.matcher(email);
            isValid = matcher.matches();
        } catch(Exception e) {
            isValid = false;
        }
        return isValid;
    }

    public List<String> readEmailFromFile(String filePath) {
        List<String> emailList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String temp = null;
            int line = 0;
            while((temp = reader.readLine()) != null) {
                temp = temp.trim();
                if(checkEmail(temp)) {
                    emailList.add(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return emailList;
    }

    public static void main(String ... args) {
        List<String> emailList = new FileReaderUtil().readEmailFromFile("/your/path");
        for(String item: emailList) {
            System.out.println(item);
        }
    }
}
