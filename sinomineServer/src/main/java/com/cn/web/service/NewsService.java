package com.cn.web.service;

import com.cn.jpa.dao.NewsDao;
import com.cn.jpa.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public News saveAndFlush(News news) {
        return newsDao.saveAndFlush(news);
    }

    public void delete(News news) {
        newsDao.delete(news);
    }

    public News findById(String newsid) {
        return newsDao.getOne(newsid);
    }

    public Page<News> findAllOrderByOrderNum(int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.ASC, "ordernum");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return newsDao.findAll(pageable);
    }

    public Page<News> findAllOrderByCreateTime(int pageSize, int pageNum) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createTime");
        Pageable pageable = PageRequest.of(pageSize, pageNum, sort);
        return newsDao.findAll(pageable);
    }
}
