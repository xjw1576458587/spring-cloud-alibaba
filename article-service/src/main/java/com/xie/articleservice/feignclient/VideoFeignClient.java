package com.xie.articleservice.feignclient;

import com.xie.articleservice.dto.ResponseObject;
import com.xie.articleservice.entity.Video;
import com.xie.articleservice.feignclient.fallback.VideoFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiemouren
 */
@FeignClient(value = "video-service",fallbackFactory = VideoFeignClientFallbackFactory.class)
public interface VideoFeignClient {
    @GetMapping("/video")
    ResponseObject<Video> findByArticleId(@RequestParam("articleId") long articleId);
}
