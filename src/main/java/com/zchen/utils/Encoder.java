package com.zchen.utils;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author Zhouce Chen
 * @version Nov 21, 2013
 */
public class Encoder {
    public static String standardEncode(String password) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        return encoder.encode(password);
    }
}
