package com.ro.portfolio.model;

import lombok.Data;

@Data
public class TokenModel {
    private String visitorUrl;
    private String visitorKey;
    private String baseURL;
    private String fetchIpURL;

    public TokenModel(String baseURL, String visitorUrl, String visitorKey, String fetchIpURL) {
        this.baseURL = baseURL;
        this.visitorUrl = visitorUrl;
        this.visitorKey = visitorKey;
        this.fetchIpURL = fetchIpURL;
    }
}
