package com.xie.articleservice.entity;

public class Video {
//    确保类属性与JSON属性名与类型一致
    private Long videoId;
    private String sn;
    private Float videoLength;
    private String cover;
    private String videoUrl;
    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Float getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Float videoLength) {
        this.videoLength = videoLength;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
