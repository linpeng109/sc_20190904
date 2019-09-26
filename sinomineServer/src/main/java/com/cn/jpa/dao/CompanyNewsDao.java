package com.cn.jpa.dao;

import com.cn.jpa.entity.CompanyNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyNewsDao extends JpaRepository<CompanyNews, String> {
}
