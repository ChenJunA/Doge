package com.doge.service;

import com.doge.dto.ArticleDTO;
import com.doge.entity.Article;

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
}
