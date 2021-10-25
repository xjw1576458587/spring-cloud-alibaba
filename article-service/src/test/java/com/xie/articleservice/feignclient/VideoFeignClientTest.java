package com.xie.articleservice.feignclient;

import com.xie.articleservice.entity.Video;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoFeignClientTest {
    @Resource
    private VideoFeignClient videoFeignClient;
    @Test
    public void testFindByArticleId() {
        Video video = videoFeignClient.findByArticleId(1648).getData();
        System.out.println(video);
    }

    @Test
    public void testFindByArticleId1() {
        for (int i = 0; i < 10; i++) {
            Video video = videoFeignClient.findByArticleId(1648).getData();
            System.out.println(video);
        }

    }

}