package com.xie.articleservice.controller;

import com.xie.articleservice.dto.ResponseObject;
import com.xie.articleservice.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 如果是VIP会员,可以查看所有普通文章与精选文章
     * 如果是普通会员,只能查看所有普通文章
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseObject list() {

        return new ResponseObject("0", "success", articleService.list());
    }

}
