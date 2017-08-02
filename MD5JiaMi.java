package com.example.myapplication.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shido on 2017/5/23.
 */

public class MD5JiaMi {
    public static String MD5JiaMi(String str){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(str.getBytes());
            String result = "";
            for (byte d:digest) {
                String s = Integer.toHexString(d & 0xff);
                if (s.length()==1){
                    s="0"+s;
                }
                result+=s;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
