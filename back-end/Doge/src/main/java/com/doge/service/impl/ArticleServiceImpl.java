package com.doge.service.impl;

import com.doge.comparator.HotComparator;
import com.doge.dto.ArticleDTO;
import com.doge.dto.ReplyDTO;
import com.doge.entity.*;
import com.doge.mapper.ArticleMapper;
import com.doge.mapper.FollowMapper;
import com.doge.mapper.PictureMapper;
import com.doge.mapper.ReplyMapper;
import com.doge.service.ArticleService;
import com.doge.service.FileService;
import com.doge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    FollowMapper followMapper;

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

            //论坛图片集合
            List<String> picsList = new ArrayList<>();
            for (Picture pic :
                    pictures) {
                picsList.add(pic.getPicture());
            }

            articleDTO.setPictures(picsList);

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

    @Override
    public ArticleDTO getArticleById(Long articleId) throws Exception {
        Article article = articleMapper.selectByPrimaryKey(articleId);

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

        //论坛图片集合
        List<String> picsList = new ArrayList<>();
        for (Picture pic :
                pictures) {
            picsList.add(pic.getPicture());
        }

        articleDTO.setPictures(picsList);

        //设置用户名
        String username = userService.getUserById(article.getUserId()).getUsername();
        articleDTO.setUsername(username);

        return articleDTO;
    }

    @Override
    public List<ReplyDTO> insertReply(Reply reply) throws Exception {
        replyMapper.insertSelective(reply);
        //对应文章下回复数量+1
        Article article = articleMapper.selectByPrimaryKey(reply.getArticleId());
        article.setReplyNum(article.getReplyNum() + 1);
        articleMapper.updateByPrimaryKeySelective(article);

        List<ReplyDTO> replyDTOS = listAllReply(reply.getArticleId());
        return replyDTOS;
    }

    @Override
    public List<ReplyDTO> listAllReply(Long articleId) throws Exception {
        ReplyExample replyExample = new ReplyExample();
        replyExample.createCriteria().andArticleIdEqualTo(articleId);
        List<Reply> replies = replyMapper.selectByExample(replyExample);

        return toReplyDTO(replies);
    }

    @Override
    public List<ReplyDTO> listAllArticleReply() throws Exception {
        ReplyExample replyExample = new ReplyExample();
        replyExample.setOrderByClause("id desc");
        List<Reply> replies = replyMapper.selectByExample(replyExample);
        return toReplyDTO(replies);

    }

    @Override
    public void addViewNum(Long articleId) throws Exception {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        article.setViewNum(article.getViewNum() + 1);
        articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public List<ArticleDTO> findHotArticles() throws Exception {
        List<ArticleDTO> articleDTOS = listAllArticle();
        Collections.sort(articleDTOS, new HotComparator());
        if(articleDTOS.size() <= 10){
            return articleDTOS;
        } else {
            return articleDTOS.subList(0,10);
        }

    }

    @Override
    public List<ArticleDTO> getRecommendArticles() throws Exception {
        List<ArticleDTO> articleDTOS = listAllArticle();
        List<ArticleDTO> respArticleDTOS = new ArrayList<>();
        for(ArticleDTO articleDTO:articleDTOS){
            if (articleDTO.getId() % 3 == 0){
                respArticleDTOS.add(articleDTO);
            }
        }
        return respArticleDTOS;
    }

    @Override
    public List<ArticleDTO> getFollowArticles(Long userId) throws Exception {
        FollowExample followExample = new FollowExample();
        followExample.createCriteria().andUserIdEqualTo(userId);
        List<Follow> follows = followMapper.selectByExample(followExample);
        List<ArticleDTO> respArticleDTOS = new ArrayList<>();
        for(Follow follow : follows){
            List<ArticleDTO> articleDTOS = listArticleByUserId(follow.getFollowerId());
            respArticleDTOS.addAll(articleDTOS);
        }
        return respArticleDTOS;
    }

    @Override
    public List<ArticleDTO> listArticleByUserId(Long userId) throws Exception {
        List<ArticleDTO> articleDTOS = listAllArticle();
        List<ArticleDTO> respArticleDTOS = new ArrayList<>();
        for(ArticleDTO articleDTO:articleDTOS){
            if (articleDTO.getUserId() == userId){
                respArticleDTOS.add(articleDTO);
            }
        }
        return respArticleDTOS;

    }

    @Override
    public void reCoverArticleReply(Long replyId) throws Exception {
        Reply reply = replyMapper.selectByPrimaryKey(replyId);
        reply.setIsDelete(false);
        replyMapper.updateByPrimaryKeySelective(reply);
    }

    @Override
    public void deleteArticleReply(Long replyId) throws Exception {
        Reply reply = replyMapper.selectByPrimaryKey(replyId);
        reply.setIsDelete(true);
        replyMapper.updateByPrimaryKeySelective(reply);
    }

    @Override
    public void deleteArticle(Long articleId) throws Exception {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        article.setIsDelete(true);
        articleMapper.updateByPrimaryKeySelective(article);

    }

    @Override
    public void reCoverArticle(Long articleId) throws Exception {
        Article article = articleMapper.selectByPrimaryKey(articleId);
        article.setIsDelete(false);
        articleMapper.updateByPrimaryKeySelective(article);
    }

    private List<ReplyDTO> toReplyDTO(List<Reply> replies) throws Exception{
        List<ReplyDTO> replyDTOS = new ArrayList<>();
        for (Reply reply : replies) {
            ReplyDTO replyDTO = new ReplyDTO();
            replyDTO.setId(reply.getId());
            replyDTO.setGmtCreate(reply.getGmtCreate());
            replyDTO.setGmtModified(reply.getGmtModified());
            replyDTO.setArticleId(reply.getArticleId());
            replyDTO.setParentId(reply.getParentId());
            replyDTO.setReplyId(reply.getReplyId());
            replyDTO.setContent(reply.getContent());
            replyDTO.setDelete(reply.getIsDelete());
            replyDTO.setUserId(reply.getUserId());

            //查找用户
            User user = userService.getUserById(reply.getUserId());
            replyDTO.setUsername(user.getUsername());
            replyDTO.setBiography(user.getBiography());
            replyDTO.setAvatar(user.getAvatar());

            //查找评论数量
            ReplyExample replyNumExample = new ReplyExample();
            replyNumExample.createCriteria().andParentIdEqualTo(reply.getId());
            List<Reply> numReplies = replyMapper.selectByExample(replyNumExample);
            replyDTO.setReplyNum(numReplies.size());

            replyDTOS.add(replyDTO);
        }
        return replyDTOS;
    }
}
