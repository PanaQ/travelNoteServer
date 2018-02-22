package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.util.AesCryptUtil;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

/**
 * Created by Jingly on 2018/2/22.
 */
@Service
public class PasswordEncodeServiceImpl implements PasswordEncodeService {
    @Override
    public String encode(String password) {
        return new String(Base64.encode(new Sha256Hash(password).getBytes()));
    }

    @Override
    public boolean match(String inputPassword, String dbPassword) {
        try {
            String decPassword = AesCryptUtil.decrypt(inputPassword);
            String encodedPassword = encode(decPassword);
            if (encodedPassword.equals(dbPassword)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
