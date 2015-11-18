package com.sandbox.httpclient;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public final static int TIMEOUT = 5000;

    private static PoolingHttpClientConnectionManager connManager = null;
    private static CloseableHttpClient httpClient = null;

    static {

        connManager = new PoolingHttpClientConnectionManager();
        httpClient = HttpClients.custom().setConnectionManager(connManager).build();
        // Create socket configuration
//            SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
//            connManager.setDefaultSocketConfig(socketConfig);
//            // Create message constraints
//            MessageConstraints messageConstraints = MessageConstraints.custom()
//                    .setMaxHeaderCount(200)
//                    .setMaxLineLength(2000)
//                    .build();
//            // Create connection configuration
//            ConnectionConfig connectionConfig = ConnectionConfig.custom()
//                    .setMalformedInputAction(CodingErrorAction.IGNORE)
//                    .setUnmappableInputAction(CodingErrorAction.IGNORE)
//                    .setCharset(Consts.UTF_8)
//                    .setMessageConstraints(messageConstraints)
//                    .build();
//            connManager.setDefaultConnectionConfig(connectionConfig);
        connManager.setMaxTotal(300);
        connManager.setDefaultMaxPerRoute(50);

    }

    private static RequestConfig buildRequestConfig(int soTimeout, int connectTimeout, int connectionRequestTimeout) {
        return RequestConfig.custom()
                .setSocketTimeout(soTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout).build();
    }

    private static RequestConfig buildRequestConfig(int soTimeout, int connectTimeout) {
        return buildRequestConfig(soTimeout, connectTimeout, TIMEOUT + 1000);
    }

    private static RequestConfig buildRequestConfig() {
        return buildRequestConfig(TIMEOUT, TIMEOUT, TIMEOUT);
    }

    public static String doGet(String url, Map<String, String> headers, int soTimeout, int connectTimeout) {
        String responseString = null;
        HttpGet get = new HttpGet(url);
        try {
            get.setConfig(buildRequestConfig(soTimeout, connectTimeout));
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    get.setHeader(entry.getKey(), entry.getValue());
                }
            }
            CloseableHttpResponse response = httpClient.execute(get);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, Consts.UTF_8);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                logger.error("get response error", e);
                return responseString;
            } finally {
                if (response != null) {
                    response.close();
                }
            }

        } catch (SocketTimeoutException e) {
            logger.error("http get SocketTimeoutException", e);
            return responseString;
        } catch (Exception e) {
            logger.error("http get Exception", e);
        } finally {
            get.releaseConnection();
        }
        return responseString;
    }

    public static String doGet(String url, int soTimeout, int connectTimeout) {
        return doGet(url, null, soTimeout, connectTimeout);
    }

    public static String doGet(String url, Map<String, String> headers) {
        return doGet(url, headers, TIMEOUT, TIMEOUT);
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }

    public static String doPost(String url, String postContent, int soTimeout, int connectTimeout) {

        HttpPost post = new HttpPost(url);
        try {
            RequestConfig requestConfig = buildRequestConfig(soTimeout, connectTimeout);

            post.setConfig(requestConfig);

            post.setEntity(new StringEntity(postContent, Consts.UTF_8));

            CloseableHttpResponse response = httpClient.execute(post);
            try {
                int status = response.getStatusLine().getStatusCode();

                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        String result = EntityUtils.toString(entity, Consts.UTF_8);
                        if (status == HttpStatus.SC_OK) {
                            logger.debug("url :{} , response string:{}", url, result);
                            return result;
                        } else {
                            logger.error("status:{},url :{} ,response :{} ", status, url, result);
                            return "ERROR-" + status;
                        }
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }

            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException,{}", e.getMessage());
        } catch (Exception e) {
            logger.error("Exception,{}", e.getMessage());
        } finally {
            post.releaseConnection();
        }
        return "";

    }

    public static String doPost(String url, String postContent) {
        return doPost(url, postContent, TIMEOUT, TIMEOUT);
    }


    public static String doPost(String url, Map<String, String> headers
            , Map<String, String> params, int soTimeout, int connectTimeout) {

        String responseContent = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setConfig(buildRequestConfig(soTimeout, connectTimeout));
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));

            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                // 执行POST请求
                HttpEntity entity = response.getEntity(); // 获取响应实体
                try {
                    if (null != entity) {
                        responseContent = EntityUtils.toString(entity, Consts.UTF_8);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        } finally {
            httpPost.releaseConnection();
        }
        return responseContent;

    }

    public static String doPost(String url, Map<String, String> headers, Map<String, String> params) {
        return doPost(url, headers, params, TIMEOUT, TIMEOUT);
    }

    public static String doPost(String url, Map<String, String> params) {
        return HttpClientUtils.doPost(url, null, params);
    }

    public static String doPostMulti(String url, Map<String, ContentBody> params, int soTimeout, int connectTimeout) {

        String responseContent = null;

        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setConfig(buildRequestConfig(soTimeout, connectTimeout));

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            for (Map.Entry<String, ContentBody> entry : params.entrySet()) {
                multipartEntityBuilder.addPart(entry.getKey(), entry.getValue());
            }

            HttpEntity reqEntity = multipartEntityBuilder.build();

            httpPost.setEntity(reqEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                // 执行POST请求
                HttpEntity entity = response.getEntity(); // 获取响应实体
                try {
                    if (null != entity) {
                        responseContent = EntityUtils.toString(entity, Consts.UTF_8);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        } finally {
            httpPost.releaseConnection();
        }
        return responseContent;

    }

    public static String doPostMulti(String url, Map<String, ContentBody> params) {
        return doPostMulti(url, params, TIMEOUT, TIMEOUT);
    }

    public static String doDelete(String url, int soTimeout, int connectTimeout) {
        String responseString = null;
        HttpDelete httpDelete = new HttpDelete(url);
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(TIMEOUT)
                    .setConnectTimeout(TIMEOUT)
                    .setConnectionRequestTimeout(TIMEOUT).build();
            httpDelete.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpDelete);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, Consts.UTF_8);
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                logger.error("get response error", e);
                return responseString;
            } finally {
                if (response != null) {
                    response.close();
                }
            }

        } catch (SocketTimeoutException e) {
            logger.error("http get SocketTimeoutException", e);
            return responseString;
        } catch (Exception e) {
            logger.error("http get Exception", e);
        } finally {
            httpDelete.releaseConnection();
        }
        return responseString;
    }

    public static String doDelete(String url) {
        return doDelete(url, TIMEOUT, TIMEOUT);
    }

}
