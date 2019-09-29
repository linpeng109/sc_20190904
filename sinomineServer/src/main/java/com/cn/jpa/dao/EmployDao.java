package com.cn.jpa.dao;

import com.cn.jpa.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployDao extends JpaRepository<Employ, String> {
}
