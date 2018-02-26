package com.garfield.travelnote.biz.service;

/**
 * Created by Jingly on 2018/2/22.
 */
public interface PasswordEncodeService {
    String encode(String var1);

    boolean match(String var1, String var2);
}
