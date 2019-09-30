package com.cn.jpa.dao;

import com.cn.jpa.entity.SoftwareProductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareProductorDao extends JpaRepository<SoftwareProductor, String> {
}
