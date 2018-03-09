package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.biz.service.PasswordEncodeService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

/**
 * Created by Jingly on 2018/2/22.
 */
@Deprecated
@Service
public class PasswordEncodeServiceImpl implements PasswordEncodeService {
    @Override
    public String encode(String password) {
        return new String(Base64.encode(new Sha256Hash(password).getBytes()));
    }

    @Override
    public boolean match(String inputPassword, String dbPassword) {
        try {
            String encodedPassword = encode(inputPassword);
            if (encodedPassword.equals(dbPassword)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String password = "123456";
        String dbPassword = new String(Base64.encode(new Sha256Hash(password).getBytes()));
        System.out.println(dbPassword);
    }
}
