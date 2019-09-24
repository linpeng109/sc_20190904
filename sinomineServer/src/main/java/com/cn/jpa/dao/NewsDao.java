package com.cn.jpa.dao;

import com.cn.jpa.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDao extends JpaRepository<News, String> {
}
