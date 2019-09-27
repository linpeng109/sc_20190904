package com.cn.jpa.dao;

import com.cn.jpa.entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportDao extends JpaRepository<Support, String> {
}
