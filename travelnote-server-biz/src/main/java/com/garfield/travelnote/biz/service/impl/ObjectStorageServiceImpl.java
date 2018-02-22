package com.garfield.travelnote.biz.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.garfield.travelnote.biz.service.ObjectStorageService;
import com.zhexinit.ov.common.util.EncodeUtl;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by guofe on 2016/9/17.
 */
@Service("objectStorageService")
public class ObjectStorageServiceImpl implements ObjectStorageService {

    private final String OSS_EndPoint;
    private final String OSS_AccessKeyID;
    private final String OSS_AccessKeySecret;
    private final String OSS_Bucket;
    private final String OSS_ImageService;

    public ObjectStorageServiceImpl(String oss_endPoint, String oss_accessKeyID, String oss_accessKeySecret, String oss_bucket, String oss_imageService) {
        OSS_EndPoint = oss_endPoint;
        OSS_AccessKeyID = oss_accessKeyID;
        OSS_AccessKeySecret = oss_accessKeySecret;
        OSS_Bucket = oss_bucket;
        OSS_ImageService = oss_imageService;
    }

    /**
     * 获取OSSClient
     *
     * @return
     */
    public OSSClient getClient() {
        OSSClient client = new OSSClient(OSS_EndPoint, OSS_AccessKeyID, OSS_AccessKeySecret);
        return client;
    }

    /**
     * 通过字节数组创建输入流
     *
     * @param bytes
     * @return
     */
    private InputStream createInputStreamFromBytes(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void putObject(String key, InputStream in) throws IOException {
        OSSClient client = getClient();
        PutObjectRequest request = new PutObjectRequest(OSS_Bucket, key, in);
        client.putObject(request);
        client.shutdown();
        in.close();
    }

    @Override
    public String putObjectWithMd5(String key, InputStream in) throws IOException {
        byte[] bytes = EncodeUtl.readBytes(in);
        return putObjectWithMd5(key, bytes);
    }

    @Override
    public void putObject(String key, byte[] bytes) throws IOException {
        InputStream in = createInputStreamFromBytes(bytes);
        putObject(key, in);
    }

    @Override
    public String putObjectWithMd5(String key, byte[] bytes, boolean isPublic, String contentType) throws IOException {
        String md5 = EncodeUtl.getMd5ByFile(bytes);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata("md5", md5);
        if (contentType != null) {
            metadata.setContentType(contentType);
        }

        InputStream in = createInputStreamFromBytes(bytes);
        PutObjectRequest request = new PutObjectRequest(OSS_Bucket, key, in, metadata);

        OSSClient client = getClient();
        client.putObject(request);
        in.close();

        if (isPublic) {
            SetObjectAclRequest setObjectAclRequest = new SetObjectAclRequest(OSS_Bucket, key, CannedAccessControlList.PublicRead);
            client.setObjectAcl(setObjectAclRequest);
        }

        client.shutdown();

        return md5;
    }

    @Override
    public String putObjectWithMd5(String key, byte[] bytes) throws IOException {
        return putObjectWithMd5(key, bytes, false, null);
    }

    @Override
    public void deleteObjects(String... keys) {
        OSSClient client = getClient();
        DeleteObjectsRequest request = new DeleteObjectsRequest(OSS_Bucket);
        request.withKeys(Arrays.asList(keys));
        client.deleteObjects(request);
        client.shutdown();
    }

    @Override
    public String generateUrl(String key, Date expireDate) {
        OSSClient client = getClient();
        URL url = client.generatePresignedUrl(OSS_Bucket, key, expireDate);
        client.shutdown();
        return url.toString();
    }

    @Override
    public String getImageServiceUrl(String key, Date expireDate) {
        OSSClient client = getClient();
        URL url = client.generatePresignedUrl(OSS_Bucket, key, expireDate);
        String objectUrl = url.toString();
        String imageUrl = objectUrl.replaceFirst(url.getHost(), OSS_ImageService);

        client.shutdown();
        return imageUrl;
    }

    @Override
    public String getImageServiceUrl(String key, int expireDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, expireDays);
        return getImageServiceUrl(key, calendar.getTime());
    }
}
