package com.cn.web.service;

import com.cn.jpa.dao.ForeignExampleDao;
import com.cn.jpa.entity.ForeignExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ForeignExampleService {
    @Autowired
    private ForeignExampleDao foreignExampleDao;

    public ForeignExample saveAndFlush(ForeignExample foreignExample) {
        return foreignExampleDao.saveAndFlush(foreignExample);
    }

    public void delete(ForeignExample foreignExample) {
        foreignExampleDao.delete(foreignExample);
    }

    public ForeignExample findById(String exampleId) {
        return foreignExampleDao.getOne(exampleId);
    }

    public Page<ForeignExample> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return foreignExampleDao.findAll(pageable);
    }

    public Page<ForeignExample> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return foreignExampleDao.findAll(pageable);
    }
}
