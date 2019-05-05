package com.doge.service;

import com.doge.dto.ArticleDTO;
import com.doge.dto.ReplyDTO;
import com.doge.entity.Article;
import com.doge.entity.Reply;

import java.util.List;

/**
 * @Description: 论坛帖子Service
 * @Author: chenjun
 * @Date: 2019/5/4 23:41
 */
public interface ArticleService {
    List<ArticleDTO> insertArticle(Article article) throws Exception;

    List<ArticleDTO> listAllArticle() throws Exception;

    Long latestArticleId() throws Exception;

    ArticleDTO getArticleById(Long articleId) throws Exception;

    List<ReplyDTO> insertReply(Reply reply) throws Exception;

    List<ReplyDTO> listAllReply(Long articleId) throws Exception;

    void addViewNum(Long articleId) throws Exception;

    List<ArticleDTO> findHotArticles() throws Exception;

    List<ArticleDTO> getRecommendArticles() throws Exception;

    List<ArticleDTO> getFollowArticles(Long userId) throws Exception;

    List<ArticleDTO> listArticleByUserId(Long userId) throws Exception;
}
