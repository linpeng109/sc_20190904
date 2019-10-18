package com.cn.web.service;

import com.cn.jpa.dao.ProductorDao;
import com.cn.jpa.entity.Productor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductorService {
    @Autowired
    private ProductorDao productorDao;

    public Productor saveAndFlush(Productor productor) {
        return productorDao.saveAndFlush(productor);
    }

    public void delete(Productor productor) {
        productorDao.delete(productor);
    }

    public Productor findId(String productorId) {
        return productorDao.getOne(productorId);
    }

    public Page<Productor> findAllOrderBycreateTime(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return productorDao.findAll(pageable);
    }

    public Page<Productor> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return productorDao.findAll(pageable);
    }
}
