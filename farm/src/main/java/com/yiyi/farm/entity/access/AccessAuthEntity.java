package com.yiyi.farm.entity.access;

import com.yiyi.farm.enumeration.http.HttpMethodEnum;
import lombok.Data;

import java.util.Arrays;

@Data
public class AccessAuthEntity {
    private String url;
    private String methodName;
    private HttpMethodEnum httpMethodEnum;
    private boolean isLogin;
    private String[] permission;

    public AccessAuthEntity(String url, String methodName, HttpMethodEnum httpMethodEnum, boolean isLogin, String[] permission) {
        this.url = url;
        this.methodName = methodName;
        this.httpMethodEnum = httpMethodEnum;
        this.isLogin = isLogin;
        this.permission = permission;
    }


}
