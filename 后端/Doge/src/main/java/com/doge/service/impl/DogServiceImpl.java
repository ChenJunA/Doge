package com.doge.service.impl;

import com.doge.entity.Dog;
import com.doge.entity.DogExample;
import com.doge.mapper.DogMapper;
import com.doge.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public void insertDog(Dog dog) throws Exception {
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
    public Dog findById(Long dogId) throws Exception {
        Dog dog = dogMapper.selectByPrimaryKey(dogId);
        return dog;
    }

    @Override
    public List<Dog> listAll() throws Exception {
        DogExample dogExample = new DogExample();
        dogExample.setOrderByClause("id asc");
        List<Dog> dogs = dogMapper.selectByExample(dogExample);
        return dogs;
    }

    @Override
    public List<Dog> listByType(Long typeId) throws Exception {
        DogExample dogExample = new DogExample();
        dogExample.createCriteria().andTypeEqualTo(typeId);
        List<Dog> dogs = dogMapper.selectByExample(dogExample);
        return dogs;
    }
}
