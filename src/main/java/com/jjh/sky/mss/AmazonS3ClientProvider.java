package com.jjh.sky.mss;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;

import java.io.IOException;
import java.net.URL;

/**
 * Created by jiajianhong on 16/12/16.
 */
public class AmazonS3ClientProvider {

    /**
     * <p>
     * 创建AmazonS3Client
     * </p>
     *
     *       @accessKey:mss用户的access key
     *        secretKey:mss用户的access secret
     *        url:mss server hostname,一般为mtmss.com
     */
    private static String accessKey = "8cf1216eab4c4e0e9481329db5d7da4a";
    private static String secretKey = "a52e460e9d5349388b91a14b2230a3a8";
    private static String url = "http://mtmos.com";
    static AmazonS3Client s3conn;

    public static AmazonS3 CreateAmazonS3Conn()
            throws IOException {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        //clientConfig.setSignerOverride("S3SignerType");

        URL ep = new URL(url);
        if (ep.getProtocol().equalsIgnoreCase("http")) {
            clientConfig.setProtocol(Protocol.HTTP);
        } else if (ep.getProtocol().equalsIgnoreCase("https")) {
            clientConfig.setProtocol(Protocol.HTTPS);
        } else {
            throw new IOException("Unsupported protocol");
        }
        String endpoint = ep.getHost();
        if (ep.getPort() > 0) {
            endpoint += ":" + ep.getPort();
        }

        S3ClientOptions s3ClientOptions = new S3ClientOptions();
        // mss only support path style access.
        s3ClientOptions.setPathStyleAccess(true);
        s3conn = new AmazonS3Client(credentials, clientConfig);
        s3conn.setS3ClientOptions(s3ClientOptions);
        s3conn.setEndpoint(endpoint);
        //s3conn.setSignerRegionOverride("S3SignerType");
        return s3conn;
    }
}
