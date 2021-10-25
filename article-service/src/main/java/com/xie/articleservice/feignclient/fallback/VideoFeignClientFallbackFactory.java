package com.xie.articleservice.feignclient.fallback;

import com.xie.articleservice.dto.ResponseObject;
import com.xie.articleservice.entity.Video;
import com.xie.articleservice.feignclient.VideoFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class VideoFeignClientFallbackFactory implements FallbackFactory<VideoFeignClient> {
    @Override
    public VideoFeignClient create(Throwable throwable) {
        return new VideoFeignClient() {
            @Override
            public ResponseObject<Video> findByArticleId(long articleId) {
                Video video = new Video();
                video.setVideoId(-1L);
                video.setSn("UNKNOWN");
                return new ResponseObject<>(throwable.getClass().getSimpleName(),"限流或熔断",video);
            }
        };
    }
}
