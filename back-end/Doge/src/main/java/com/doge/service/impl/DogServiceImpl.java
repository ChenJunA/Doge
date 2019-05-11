package com.doge.service.impl;

import com.doge.dto.DogDTO;
import com.doge.entity.*;
import com.doge.mapper.DogCollectionMapper;
import com.doge.mapper.DogMapper;
import com.doge.mapper.PictureMapper;
import com.doge.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    DogCollectionMapper dogCollectionMapper;


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
    public List<Dog> deleteDog(Long dogId) throws Exception {
        Dog dog = dogMapper.selectByPrimaryKey(dogId);
        dog.setIsDelete(true);
        dogMapper.updateByPrimaryKeySelective(dog);
        return listAll();
    }

    @Override
    public List<Dog> reCover(Long dogId) throws Exception {
        Dog dog = dogMapper.selectByPrimaryKey(dogId);
        dog.setIsDelete(false);
        dogMapper.updateByPrimaryKeySelective(dog);
        return listAll();
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
    public List<Dog> listDogsByCollectionId(Long collectionId) throws Exception {
        DogCollectionExample dogCollectionExample = new DogCollectionExample();
        dogCollectionExample.createCriteria().andUserIdEqualTo(collectionId);
        List<DogCollection> dogCollections = dogCollectionMapper.selectByExample(dogCollectionExample);
        List<Dog> dogs = new ArrayList<>();
        for (DogCollection dogCollection : dogCollections){
            Dog dog = dogMapper.selectByPrimaryKey(dogCollection.getDogId());
            dogs.add(dog);
        }
        setDogPicture(dogs);
        return dogs;
    }

    @Override
    public Long latestDogId() throws Exception {
        List<Dog> dogs = listAll();
        return dogs.get(0).getId();

    }

    @Override
    public DogDTO toAdopt(Long dogId, Long adoptId) throws Exception {
        Dog dog = dogMapper.selectByPrimaryKey(dogId);
        dog.setAdopt(adoptId);
        dog.setState((long) 2);
        dog.setAdoptTime(new Date());
        dogMapper.updateByPrimaryKeySelective(dog);
        DogDTO DogDTO = getDogById(dogId);
        return DogDTO;
    }

    @Override
    public void toCollect(DogCollection dogCollection) throws Exception {
        dogCollectionMapper.insertSelective(dogCollection);
    }

    @Override
    public List<DogCollection> isCollect(Long userId, Long dogId) throws Exception {
        DogCollectionExample dogCollectionExample = new DogCollectionExample();
        dogCollectionExample.createCriteria().andUserIdEqualTo(userId).andDogIdEqualTo(dogId);
        List<DogCollection> dogCollections = dogCollectionMapper.selectByExample(dogCollectionExample);
        return dogCollections;
    }

    @Override
    public DogDTO confirmAdopt(Long dogId) throws Exception {
        Dog dog = dogMapper.selectByPrimaryKey(dogId);
        dog.setState((long) 3);
        dogMapper.updateByPrimaryKeySelective(dog);
        DogDTO DogDTO = getDogById(dogId);
        return DogDTO;
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
