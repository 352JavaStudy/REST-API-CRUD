package com.rest.study.common.controller;

import java.util.UUID;

public class StringUtils {

    public static String generateUniqueName(String originName) {
        String ext = ""; // 확장자
        int dotIndex = originName.lastIndexOf(".");
        if(dotIndex > -1)
                ext = originName.substring(dotIndex);
        return UUID.randomUUID().toString() + ext;
    }
}
