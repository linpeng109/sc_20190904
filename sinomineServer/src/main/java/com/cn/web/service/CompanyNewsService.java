package com.cn.web.service;

import com.cn.jpa.dao.CompanyNewsDao;
import com.cn.jpa.entity.CompanyNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CompanyNewsService {
    @Autowired
    private CompanyNewsDao companyNewsDao;

    public CompanyNews saveAndFlush(CompanyNews companyNews) {
        return companyNewsDao.saveAndFlush(companyNews);
    }

    public CompanyNews findById(String newId) {
        return companyNewsDao.getOne(newId);
    }

    public void delete(CompanyNews companyNews) {
        companyNewsDao.delete(companyNews);
    }

    public Page<CompanyNews> findallorderbycreatetime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return companyNewsDao.findAll(pageable);
    }

    public Page<CompanyNews> findallorderbyordernum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "ordernum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return companyNewsDao.findAll(pageable);
    }

}
