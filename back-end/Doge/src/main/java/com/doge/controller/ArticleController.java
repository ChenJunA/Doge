package com.doge.controller;

import com.doge.dto.ArticleDTO;
import com.doge.dto.DogDTO;
import com.doge.dto.ReplyDTO;
import com.doge.entity.Article;
import com.doge.entity.Reply;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @ApiOperation("获取文章列表")
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

    /**
     * 查询文章详细信息
     *
     * @param articleId 文章ID
     * @return 状态信息
     */
    @ApiOperation("查询文章详细信息")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long")
    @GetMapping("/getArticleById/{articleId}")
    public RespUtil<ArticleDTO> getArticleById(@PathVariable Long articleId) throws Exception{
        ArticleDTO articleDTO = articleService.getArticleById(articleId);
        return RespUtil.success(articleDTO);
    }

    /**
     * 发表评论
     *
     * @param reply 评论内容
     * @return 状态信息
     */
    @ApiOperation("发表评论")
    @ApiImplicitParam(name = "reply", value = "评论内容", required = true, dataType = "Reply")
    @PostMapping("/insertReply")
    public RespUtil<List<ReplyDTO>> insertReply(@RequestBody Reply reply) throws Exception{
        List<ReplyDTO> replyDTOS = articleService.insertReply(reply);
        return RespUtil.success(replyDTOS);
    }

    /**
     * 查找文章所有评论
     *
     * @param articleId 文章ID
     * @return 状态信息
     */
    @ApiOperation("查找文章所有评论")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long")
    @GetMapping("/listAllReply")
    public RespUtil<List<ReplyDTO>> listAllReply(Long articleId) throws Exception{
        List<ReplyDTO> replyDTOS = articleService.listAllReply(articleId);
        return RespUtil.success(replyDTOS);
    }

    /**
     * 查找所有评论
     *
     * @return 状态信息
     */
    @ApiOperation("查找所有评论")
    @GetMapping("/listAllArticleReply")
    public RespUtil<List<ReplyDTO>> listAllArticleReply() throws Exception{
        List<ReplyDTO> replyDTOS = articleService.listAllArticleReply();
        return RespUtil.success(replyDTOS);
    }


    /**
     * 访问次数+1
     *
     * @param map 参数
     * @return 状态信息
     */
    @ApiOperation("访问次数")
    @ApiImplicitParam(name = "map", value = "参数", required = true, dataType = "Map")
    @PutMapping("/addViewNum")
    public RespUtil<ReplyDTO> addViewNum(@RequestBody Map<String,String> map) throws Exception{
        Long articleId = Long.valueOf(map.get("articleId"));
        articleService.addViewNum(articleId);
        return RespUtil.success();
    }

    /**
     * 热榜
     *
     * @return 状态信息
     */
    @ApiOperation("热榜")
    @GetMapping("/findHotArticles")
    public RespUtil<List<ArticleDTO>> findHotArticles() throws Exception{
        List<ArticleDTO> articles = articleService.findHotArticles();
        return RespUtil.success(articles);
    }

    /**
     * 推荐
     *
     * @return 状态信息
     */
    @ApiOperation("推荐")
    @GetMapping("/getRecommendArticles")
    public RespUtil<List<ArticleDTO>> getRecommendArticles() throws Exception{
        List<ArticleDTO> articles = articleService.getRecommendArticles();
        return RespUtil.success(articles);
    }

    /**
     * 关注
     *
     * @return 状态信息
     */
    @ApiOperation("关注")
    @GetMapping("/getFollowArticles")
    public RespUtil<List<ArticleDTO>> getFollowArticles(Long userId) throws Exception{
        List<ArticleDTO> articles = articleService.getFollowArticles(userId);
        return RespUtil.success(articles);
    }

    /**
     * 根据用户ID获取文章列表
     *
     * @return 状态信息
     */
    @ApiOperation("根据用户ID获取文章列表")
    @GetMapping("/listArticleByUserId")
    public RespUtil<List<ArticleDTO>> listArticleByUserId(Long userId) throws Exception {
        List<ArticleDTO> articles = articleService.listArticleByUserId(userId);
        return RespUtil.success(articles);
    }

    /**
     * 删除评论
     *
     * @return 状态信息
     */
    @ApiOperation("删除评论")
    @DeleteMapping("/deleteArticleReply/{replyId}")
    public RespUtil<Reply> deleteArticleReply(@PathVariable Long replyId) throws Exception {
        articleService.deleteArticleReply(replyId);
        return RespUtil.success();
    }

    /**
     * 恢复评论
     *
     * @return 状态信息
     */
    @ApiOperation("恢复评论")
    @DeleteMapping("/reCoverArticleReply/{replyId}")
    public RespUtil<Reply> reCoverArticleReply(@PathVariable Long replyId) throws Exception {
        articleService.reCoverArticleReply(replyId);
        return RespUtil.success();
    }

    /**
     * 删除文章
     *
     * @return 状态信息
     */
    @ApiOperation("删除文章")
    @DeleteMapping("/deleteArticle/{articleId}")
    public RespUtil<Reply> deleteArticle(@PathVariable Long articleId) throws Exception {
        articleService.deleteArticle(articleId);
        return RespUtil.success();
    }

    /**
     * 恢复文章
     *
     * @return 状态信息
     */
    @ApiOperation("恢复文章")
    @DeleteMapping("/reCoverArticle/{articleId}")
    public RespUtil<Reply> reCoverArticle(@PathVariable Long articleId) throws Exception {
        articleService.reCoverArticle(articleId);
        return RespUtil.success();
    }
}
