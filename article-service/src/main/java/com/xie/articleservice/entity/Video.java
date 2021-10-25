package com.xie.articleservice.entity;

public class Video {
    private Long videoId;
    private String sn;
    private Float videoLength;
    private String cover;
    private String videoUrl;

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", sn='" + sn + '\'' +
                ", videoLength=" + videoLength +
                ", cover='" + cover + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }

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
