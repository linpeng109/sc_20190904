package com.cn.jpa.dao;

import com.cn.jpa.entity.InlandExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InlandExampleDao extends JpaRepository<InlandExample, String> {
}
