package com.cn.jpa.dao;

import com.cn.jpa.entity.Authority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorityDao extends PagingAndSortingRepository<Authority, String> {
    public List<Authority> findAll();

    public Page<Authority> findAll(Pageable pageable);

    public long count();

    public Authority save(Authority authority);

    public void delete(Authority authority);
}
