package com.doge.controller;

import com.doge.dto.ArticleDTO;
import com.doge.entity.Article;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 论坛帖子Controller
 * @Author: chenjun
 * @Date: 2019/5/4 23:40
 */
@RestController
public class ArticleController extends BaseController{
    /**
     * 发表文章
     *
     * @param article 文章信息
     * @return 状态信息
     */
    @ApiOperation("发表文章")
    @ApiImplicitParam(name = "article", value = "文章信息", required = true, dataType = "Article")
    @PostMapping("/insertArticle")
    public RespUtil<List<Article>> insertArticle(@RequestBody Article article) throws Exception {
        List<ArticleDTO> articleDTOS = articleService.insertArticle(article);
        return RespUtil.success(articleDTOS);
    }

    /**
     * 获取文章列表
     *
     * @return 状态信息
     */
    @ApiOperation("发表文章")
    @GetMapping("/listAllArticle")
    public RespUtil<List<ArticleDTO>> listAllArticle() throws Exception {
        List<ArticleDTO> articles = articleService.listAllArticle();
        return RespUtil.success(articles);
    }

    /**
     * 最新文章ID
     *
     * @return 状态信息
     */
    @ApiOperation("最新文章ID")
    @GetMapping("/latestArticleId")
    public RespUtil<Long> latestArticleId() throws Exception {
        Long articleId = articleService.latestArticleId();
        return RespUtil.success(articleId);
    }
}
