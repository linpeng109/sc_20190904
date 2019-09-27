package com.cn.web.service;

import com.cn.jpa.dao.InlandExampleDao;
import com.cn.jpa.entity.InlandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InlandExampleService {
    @Autowired
    private InlandExampleDao inlandExampleDao;

    public InlandExample saveAndFlush(InlandExample inlandExample) {
        return inlandExampleDao.saveAndFlush(inlandExample);
    }

    public void delete(InlandExample inlandExample) {
        inlandExampleDao.delete(inlandExample);
    }

    public Page<InlandExample> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return inlandExampleDao.findAll(pageable);
    }

    public Page<InlandExample> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return inlandExampleDao.findAll(pageable);
    }
}
