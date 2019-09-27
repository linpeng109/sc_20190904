package com.cn.web.service;

import com.cn.jpa.dao.ClazzSupportDao;
import com.cn.jpa.entity.ClazzSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClazzSupportService {
    @Autowired
    private ClazzSupportDao clazzSupportDao;

    public ClazzSupport saveAndFlush(ClazzSupport clazzSupport) {
        return clazzSupportDao.saveAndFlush(clazzSupport);
    }

    public void delete(ClazzSupport clazzSupport) {
        clazzSupportDao.delete(clazzSupport);
    }

    public Page<ClazzSupport> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return clazzSupportDao.findAll(pageable);
    }

    public Page<ClazzSupport> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return clazzSupportDao.findAll(pageable);
    }
}
