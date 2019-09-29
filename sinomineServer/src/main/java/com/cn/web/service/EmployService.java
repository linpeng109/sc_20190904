package com.cn.web.service;

import com.cn.jpa.dao.EmployDao;
import com.cn.jpa.entity.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployService {
    @Autowired
    private EmployDao employDao;

    public Employ saveAndFlush(Employ employ) {
        return employDao.saveAndFlush(employ);
    }

    public void delete(Employ employ) {
        employDao.delete(employ);
    }

    public Page<Employ> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return employDao.findAll(pageable);
    }

    public Page<Employ> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return employDao.findAll(pageable);
    }
}
