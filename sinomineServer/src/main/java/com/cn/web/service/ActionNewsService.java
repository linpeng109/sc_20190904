package com.cn.web.service;

import com.cn.jpa.dao.ActionNewsDao;
import com.cn.jpa.entity.ActionNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActionNewsService {
    @Autowired
    private ActionNewsDao actionNewsDao;

    public ActionNews save(ActionNews actionNews) {
        return actionNewsDao.saveAndFlush(actionNews);
    }

    public void delete(ActionNews actionNews) {
        actionNewsDao.delete(actionNews);
    }

    public ActionNews findById(String newsId) {
        return actionNewsDao.getOne(newsId);
    }

    public Page<ActionNews> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return actionNewsDao.findAll(pageable);
    }

    public Page<ActionNews> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = Sort.by(Sort.Direction.DESC, "ordernum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return actionNewsDao.findAll(pageable);
    }
}
