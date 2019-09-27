package com.cn.web.service;

import com.cn.jpa.dao.AnswerSupportDao;
import com.cn.jpa.entity.AnswerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AnswerSupportService {
    @Autowired
    private AnswerSupportDao answerSupportDao;

    public AnswerSupport save(AnswerSupport answerSupport) {
        return answerSupportDao.saveAndFlush(answerSupport);
    }

    public void delete(AnswerSupport answerSupport) {
        answerSupportDao.delete(answerSupport);
    }

    public Page<AnswerSupport> findAllOrderBycreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return answerSupportDao.findAll(pageable);
    }

    public Page<AnswerSupport> findAllOrderByOrdernum(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        Pageable pageable = PageRequest.of(pagesize, pagenum, sort);
        return answerSupportDao.findAll(pageable);
    }
}
