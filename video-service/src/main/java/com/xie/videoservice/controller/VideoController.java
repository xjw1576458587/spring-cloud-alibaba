package com.xie.videoservice.controller;

import com.xie.videoservice.dto.ResponseObject;
import com.xie.videoservice.entity.Video;
import com.xie.videoservice.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VideoController {
    @Resource
    private VideoService videoService;

    @GetMapping("/video")
    public ResponseObject<Video> findByArticleId(Long articleId){
        ResponseObject<Video> videoResponseObject = new ResponseObject<>(videoService.findByArticleId(articleId));
        return videoResponseObject;
    }
}
