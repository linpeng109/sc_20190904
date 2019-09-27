package com.cn.jpa.dao;

import com.cn.jpa.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleDao extends JpaRepository<Example,String> {
}
