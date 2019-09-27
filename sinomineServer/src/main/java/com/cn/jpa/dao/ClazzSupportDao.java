package com.cn.jpa.dao;

import com.cn.jpa.entity.ClazzSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzSupportDao extends JpaRepository<ClazzSupport, String> {
}
