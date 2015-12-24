package com.sandbox.url;

import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author: zhangxin
 * Date:   15-12-24
 */
public class BaiduApi {

    public static void main(String ... args) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
//        HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        HttpMessageConverter jacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.setMessageConverters(Arrays.asList(new HttpMessageConverter[]{
//                formHttpMessageConverter,
                stringHttpMessageConverter,
                jacksonHttpMessageConverter}));

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", "c81b320919308e26b745f5020b1eab33");

        HttpEntity entity = new HttpEntity(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://apis.baidu.com/apistore/stockservice/stock")
                .queryParam("stockid", "sz000938")
                .queryParam("list", "1");

        ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());

        ResponseEntity<BaiduStockRespose> objResponse = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, BaiduStockRespose.class);
        BaiduStockRespose obj = objResponse.getBody();
        System.out.println(obj.getErrMsg());
        System.out.println(obj.getErrNum());
        System.out.println(obj.getRetData().getStockinfo().get(0).getCode());
        System.out.println(obj.getRetData().getStockinfo().get(0).getName());
        System.out.println(obj.getRetData().getStockinfo().get(0).getClosingPrice());

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd HH:MM:SS", Locale.CHINA);
        Date date = dateFormat.parse("2015-12-24 12:12:12");
        System.out.println(date.toString());
        System.out.println(date.getTime());
    }
}
