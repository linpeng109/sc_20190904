package com.cn.jpa.dao;

import com.cn.jpa.entity.ForeignExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignExampleDao extends JpaRepository<ForeignExample, String> {
}
