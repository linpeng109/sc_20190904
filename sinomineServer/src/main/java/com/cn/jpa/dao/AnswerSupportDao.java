package com.cn.jpa.dao;

import com.cn.jpa.entity.AnswerSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerSupportDao extends JpaRepository<AnswerSupport, String> {
}
