package com.doge.service.impl;

import com.doge.dto.ArticleDTO;
import com.doge.entity.Article;
import com.doge.entity.ArticleExample;
import com.doge.entity.Picture;
import com.doge.entity.PictureExample;
import com.doge.mapper.ArticleMapper;
import com.doge.mapper.PictureMapper;
import com.doge.service.ArticleService;
import com.doge.service.FileService;
import com.doge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/4 23:42
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserService userService;
    @Autowired
    PictureMapper pictureMapper;

    @Override
    public List<ArticleDTO> insertArticle(Article article) throws Exception {
        articleMapper.insertSelective(article);
        List<ArticleDTO> articleDTOS = listAllArticle();
        return articleDTOS;
    }

    @Override
    public List<ArticleDTO> listAllArticle() throws Exception {
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("id desc");
        List<Article> articles = articleMapper.selectByExample(articleExample);
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(article.getId());
            articleDTO.setGmtCreate(article.getGmtCreate());
            articleDTO.setGmtModified(article.getGmtModified());
            articleDTO.setContent(article.getContent());
            articleDTO.setDelete(article.getIsDelete());
            articleDTO.setReplyNum(article.getReplyNum());
            articleDTO.setViewNum(article.getViewNum());
            articleDTO.setTitle(article.getTitle());
            articleDTO.setUserId(article.getUserId());

            //设置图片
            PictureExample pictureExample = new PictureExample();
            pictureExample.createCriteria().andCategoryEqualTo((long) 3).andXIdEqualTo(article.getId());
            List<Picture> pictures = pictureMapper.selectByExample(pictureExample);
            if (!pictures.isEmpty()) {
                articleDTO.setPicture(pictures.get(0).getPicture());
            }
            //设置用户名
            String username = userService.getUserById(article.getUserId()).getUsername();
            articleDTO.setUsername(username);

            articleDTOS.add(articleDTO);
        }
        return articleDTOS;
    }

    @Override
    public Long latestArticleId() throws Exception {
        List<ArticleDTO> articleDTOS = listAllArticle();
        if (articleDTOS.isEmpty()) {
            return (long) 0;
        }
        return articleDTOS.get(0).getId();
    }
}
