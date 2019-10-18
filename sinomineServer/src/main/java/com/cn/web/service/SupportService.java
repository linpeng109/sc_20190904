package com.cn.web.service;

import com.cn.jpa.dao.SupportDao;
import com.cn.jpa.entity.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
    @Autowired
    private SupportDao supportDao;

    public Support save(Support support) {
        return supportDao.saveAndFlush(support);
    }

    public void delete(Support support) {
        supportDao.delete(support);
    }

    public Support findById(String supportId) {
        return supportDao.getOne(supportId);
    }

    public Page<Support> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return supportDao.findAll(pageable);
    }

    public Page<Support> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return supportDao.findAll(pageable);
    }
}
