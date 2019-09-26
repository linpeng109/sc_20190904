package com.cn.web.service;

import com.cn.jpa.dao.ActionNewsDao;
import com.cn.jpa.entity.ActionNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Page<ActionNews> findallorderbycreatetime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return actionNewsDao.findAll(pageable)
                ;
    }

    public Page<ActionNews> findallorderbyordernum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "ordernum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return actionNewsDao.findAll(pageable);
    }
}
