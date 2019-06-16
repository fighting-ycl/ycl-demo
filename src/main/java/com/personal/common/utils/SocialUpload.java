package com.personal.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author Ma Zongwang
 * @ClassName:
 * @Description: TODO (这里用一句话描述这个类的作用)
 * @date 2018/4/25 下午2:12
 */
public class SocialUpload implements Serializable {
    private String userId;
    private String token;
    private String content;
    private MultipartFile cover;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }

}
