package com.personal.common.requestProtocol.encapsulationData;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ma Zongwang
 * @ClassName:
 * @Description: 好看社交APP发布图片实体类
 * @date 2018/4/24 上午11:44
 */
public class SocialReleaseEntity implements Serializable {
    private Integer userId;
    private String token;
    private String content;
    private MultipartFile cover;
    private List<MultipartFile> list;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public List<MultipartFile> getList() {
        return list;
    }

    public void setList(List<MultipartFile> list) {
        this.list = list;
    }
}
