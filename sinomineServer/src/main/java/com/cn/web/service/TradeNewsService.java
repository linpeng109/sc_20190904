package com.cn.web.service;

import com.cn.jpa.dao.TradeNewsDao;
import com.cn.jpa.entity.TradeNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TradeNewsService {
    @Autowired
    private TradeNewsDao tradeNewsDao;

    public TradeNews saveAndFlush(TradeNews tradeNews) {
        return tradeNewsDao.saveAndFlush(tradeNews);
    }

    public void delete(TradeNews tradeNews) {
        tradeNewsDao.delete(tradeNews);
    }

    public TradeNews findById(String newsId) {
        return tradeNewsDao.getOne(newsId);
    }

    public Page<TradeNews> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return tradeNewsDao.findAll(pageable);
    }

    public Page<TradeNews> findAllOrderByOrderNum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return tradeNewsDao.findAll(pageable);
    }
}
