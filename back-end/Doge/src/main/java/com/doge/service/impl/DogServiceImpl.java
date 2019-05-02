package com.doge.service.impl;

import com.doge.dto.DogDTO;
import com.doge.entity.Dog;
import com.doge.entity.DogExample;
import com.doge.entity.Picture;
import com.doge.entity.PictureExample;
import com.doge.mapper.DogMapper;
import com.doge.mapper.PictureMapper;
import com.doge.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/4/19 9:41
 */
@Service
@Transactional
public class DogServiceImpl implements DogService {
    @Autowired
    DogMapper dogMapper;
    @Autowired
    PictureMapper pictureMapper;


    @Override
    public void insertDog(Dog dog) throws Exception {
        dog.setState((long) 1);
        dogMapper.insertSelective(dog);
    }

    @Override
    public void updateDog(Dog dog) throws Exception {
        dogMapper.updateByPrimaryKeySelective(dog);
    }

    @Override
    public void deleteDog(Long dogId) throws Exception {
        dogMapper.deleteByPrimaryKey(dogId);
    }

    @Override
    public DogDTO getDogById(Long dogId) throws Exception {
        DogDTO dogDTO = new DogDTO();
        Dog dog = dogMapper.selectByPrimaryKey(dogId);

        //封装DTO
        dogDTO.setId(dog.getId());
        dogDTO.setGmtCreate(dog.getGmtCreate());
        dogDTO.setGmtModified(dog.getGmtModified());
        //类型ID转String
        if (dog.getType() == 1 || dog.getType() == 3) {
            dogDTO.setType("流浪狗");
        } else {
            dogDTO.setType("宠物狗");
        }
        dogDTO.setFoster(dog.getFoster());
        dogDTO.setAdopt(dog.getAdopt());
        dogDTO.setAdoptTime(dog.getAdoptTime());
        dogDTO.setState(dog.getState());
        dogDTO.setDogName(dog.getDogName());
        dogDTO.setSex(dog.getSex());
        dogDTO.setAge(dog.getAge());
        dogDTO.setAddress(dog.getAddress());
        //是否注射疫苗转String
        if (dog.getIsVaccine() == true) {
            dogDTO.setVaccine("已注射");
        } else {
            dogDTO.setVaccine("未注射");
        }
        dogDTO.setDogDescribe(dog.getDogDescribe());
        dogDTO.setDelete(dog.getIsDelete());

        //动物图片集合
        List<String> picsList = new ArrayList<>();

        PictureExample pictureExample = new PictureExample();
        pictureExample.createCriteria().andCategoryEqualTo((long) 2).andXIdEqualTo(dog.getId());
        List<Picture> pictures = pictureMapper.selectByExample(pictureExample);
        for (Picture pic :
                pictures) {
            picsList.add(pic.getPicture());
        }
        dogDTO.setPictures(picsList);
        return dogDTO;
    }

    @Override
    public List<Dog> listAll() throws Exception {
        DogExample dogExample = new DogExample();
        dogExample.setOrderByClause("id desc");
        List<Dog> dogs = dogMapper.selectByExample(dogExample);
        setDogPicture(dogs);
        return dogs;
    }

    @Override
    public List<Dog> listByType(Long typeId) throws Exception {
        DogExample dogExample = new DogExample();
        dogExample.setOrderByClause("id desc");
        dogExample.createCriteria().andTypeEqualTo(typeId);
        List<Dog> dogs = dogMapper.selectByExample(dogExample);
        setDogPicture(dogs);
        return dogs;
    }

    @Override
    public List<Dog> listDogsByFosterId(Long fosterId) throws Exception {
        DogExample dogExample = new DogExample();
        dogExample.setOrderByClause("id desc");
        dogExample.createCriteria().andFosterEqualTo(fosterId);
        List<Dog> dogs = dogMapper.selectByExample(dogExample);
        setDogPicture(dogs);
        return dogs;
    }

    @Override
    public List<Dog> listDogsByAdoptId(Long adoptId) throws Exception {
        DogExample dogExample = new DogExample();
        dogExample.setOrderByClause("id desc");
        dogExample.createCriteria().andAdoptEqualTo(adoptId);
        List<Dog> dogs = dogMapper.selectByExample(dogExample);
        setDogPicture(dogs);
        return dogs;
    }

    @Override
    public Long latestDogId() throws Exception {
        List<Dog> dogs = listAll();
        return dogs.get(0).getId();

    }

    void setDogPicture(List<Dog> dogs){
        for (Dog dog : dogs) {
            PictureExample pictureExample = new PictureExample();
            pictureExample.createCriteria().andCategoryEqualTo((long) 2).andXIdEqualTo(dog.getId());
            List<Picture> pictures = pictureMapper.selectByExample(pictureExample);
            if (!pictures.isEmpty()) {
                dog.setPicture(pictures.get(0).getPicture());
            }
        }
    }
}
