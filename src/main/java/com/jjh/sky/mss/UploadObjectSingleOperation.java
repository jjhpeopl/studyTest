package com.jjh.sky.mss;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;

/**
 * Created by jiajianhong on 16/12/16.
 */
public class UploadObjectSingleOperation {

    private static String bucketName     = "*** Provide bucket name ***";
    private static String objectName        = "*** objectName ***";

    public void testUploadObject() {
        try {
            AmazonS3 s3Client = AmazonS3ClientProvider.CreateAmazonS3Conn();
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File("");
            s3Client.putObject(new PutObjectRequest(
                    bucketName, objectName, file));

//            s3Client.putObject()
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
