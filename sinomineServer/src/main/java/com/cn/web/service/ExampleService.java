package com.cn.web.service;

import com.cn.jpa.dao.ExampleDao;
import com.cn.jpa.entity.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private ExampleDao exampleDao;

    public Example saveAndFlush(Example example) {
        return exampleDao.saveAndFlush(example);
    }

    public void delete(Example example) {
        exampleDao.delete(example);
    }

    public Example findById(String exampleId) {
        return exampleDao.getOne(exampleId);
    }

    public Page<Example> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return exampleDao.findAll(pageable);
    }

    public Page<Example> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return exampleDao.findAll(pageable);
    }
}
