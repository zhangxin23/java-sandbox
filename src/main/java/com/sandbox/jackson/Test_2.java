package com.sandbox.jackson;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Author: zhangxin
 * Date:   15-10-19
 */
public class Test_2 {
    public static void main(String[] args) {
        Persion bean = new Persion("AAA", "A", 1);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(bean);

        try {
            if(jsonGenerator != null) {
                jsonGenerator.flush();
            }

            if(!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            bean = null;
            System.gc();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
