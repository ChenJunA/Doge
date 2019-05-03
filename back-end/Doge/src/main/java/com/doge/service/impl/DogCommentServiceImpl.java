package com.doge.service.impl;

import com.doge.dto.DogCommentDTO;
import com.doge.entity.DogComment;
import com.doge.entity.DogCommentExample;
import com.doge.entity.User;
import com.doge.mapper.DogCommentMapper;
import com.doge.service.DogCommentService;
import com.doge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/3 20:06
 */
@Service
public class DogCommentServiceImpl implements DogCommentService {
    @Autowired
    DogCommentMapper dogCommentMapper;
    @Autowired
    UserService userService;

    @Override
    public void insertDogComment(DogComment dogComment) throws Exception {
        dogCommentMapper.insertSelective(dogComment);
    }

    @Override
    public List<DogCommentDTO> listDogComment(Long dogId) throws Exception {
        DogCommentExample dogCommentExample = new DogCommentExample();
        dogCommentExample.createCriteria().andDogIdEqualTo(dogId);
        List<DogComment> dogComments = dogCommentMapper.selectByExample(dogCommentExample);
        List<DogCommentDTO> dogCommentDTOList = new ArrayList<>();
        for(DogComment dogComment : dogComments){
            DogCommentDTO dogCommentDTO = new DogCommentDTO();
            dogCommentDTO.setId(dogComment.getId());
            dogCommentDTO.setDogId(dogComment.getDogId());
            dogCommentDTO.setContent(dogComment.getContent());
            dogCommentDTO.setDelete(dogComment.getIsDelete());
            dogCommentDTO.setGmtCreate(dogComment.getGmtCreate());
            dogCommentDTO.setGmtModified(dogComment.getGmtModified());
            User user = userService.getUserById(dogComment.getUserId());
            dogCommentDTO.setUsername(user.getUsername());
            dogCommentDTOList.add(dogCommentDTO);
        }
        return dogCommentDTOList;
    }
}
