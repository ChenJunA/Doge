package com.doge.comparator;

import com.doge.dto.ArticleDTO;

import java.util.Comparator;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/5 22:58
 */
public class HotComparator implements Comparator<ArticleDTO> {
    @Override
    public int compare(ArticleDTO o1, ArticleDTO o2) {
        int hotNum1 = (int) (o1.getViewNum() + o1.getReplyNum() * 10);
        int hotNum2 = (int) (o2.getViewNum() + o2.getReplyNum() * 10);

        return hotNum2 - hotNum1;
    }
}
