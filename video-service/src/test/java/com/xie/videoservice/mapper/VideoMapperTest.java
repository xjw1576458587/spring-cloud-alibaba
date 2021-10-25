package com.xie.videoservice.mapper;

import com.xie.videoservice.entity.Video;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VideoMapperTest {
    @Resource
    private VideoMapper videoMapper;
    @Test
    public void testFindByArticleId(){
        Video video = videoMapper.findByArticleId(1648l);
        System.out.println(video.getVideoUrl());
    }
}