package com.fwindhagauer.messenger.repository;

import com.fwindhagauer.messenger.entitiy.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<TEntity extends BaseEntity> extends JpaRepository<TEntity, Integer> {
}
