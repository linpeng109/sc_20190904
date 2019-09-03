package com.cn.web.service;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserBaseService {
    @Autowired
    private UserBaseDao userBaseDao;

    public Iterable<UserBase> findAll() {
        Iterable<UserBase> result = userBaseDao.findAll();
        return result;
    }

    public Page<UserBase> findAllByPage(Pageable pageable) {
        Page<UserBase> result = userBaseDao.findAll(pageable);
        return result;
    }

    public UserBase save(UserBase userBase) {
        UserBase result = userBaseDao.save(userBase);
        return result;
    }

    public Page<UserBase> findByUsername(String username, Pageable pageable) {
        return userBaseDao.findByUsernameStartingWith(username, pageable);

    }

    public Page<UserBase> findByUsernameLikeAndAndEnableIsTrue(String username, Pageable pageable) {
        return userBaseDao.findByUsernameLikeAndEnableIsTrue(username, pageable);
    }

    public long count() {
        return userBaseDao.count();
    }

    public void delete(UserBase userBase) {
        userBaseDao.delete(userBase);
    }
}
