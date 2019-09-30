package com.cn.web.service;

import com.cn.jpa.dao.OnlineSupportDao;
import com.cn.jpa.entity.OnlineSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OnlineSupportService {
    @Autowired
    private OnlineSupportDao onlineSupportDao;

    public OnlineSupport save(OnlineSupport onlineSupport) {
        return onlineSupportDao.saveAndFlush(onlineSupport);
    }

    public void delete(OnlineSupport onlineSupport) {
        onlineSupportDao.delete(onlineSupport);
    }

    public OnlineSupport findById(String supportId) {
        return onlineSupportDao.getOne(supportId);
    }

    public Page<OnlineSupport> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return onlineSupportDao.findAll(pageable);
    }

    public Page<OnlineSupport> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return onlineSupportDao.findAll(pageable);
    }
}
