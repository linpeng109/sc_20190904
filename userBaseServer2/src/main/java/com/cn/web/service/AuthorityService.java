package com.cn.web.service;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;

    public Authority save(Authority authority) {
        return authorityDao.save(authority);
    }

    public void delete(Authority authority) {
        authorityDao.delete(authority);
    }

    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    public Page<Authority> findAllByPage(Pageable pageable) {
        return authorityDao.findAll(pageable);
    }
}
