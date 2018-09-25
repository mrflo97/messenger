package com.fwindhagauer.messenger.services;


import com.fwindhagauer.messenger.entitiy.BaseEntity;
import com.fwindhagauer.messenger.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.util.List;

@MappedSuperclass
public abstract class BaseService<TEntity extends BaseEntity, TRepository extends BaseRepository<TEntity>> {
	@Autowired
	private TRepository concreteRepository;

	public List<TEntity> findAll() {
		return this.concreteRepository.findAll();
	}

	public TEntity findById(Integer id) {
		return this.concreteRepository.findById(id).get();
	}

	@Transactional
	public TEntity saveEntity(TEntity tEntity) {
		return this.concreteRepository.save(tEntity);
	}

	@Transactional
	public void delete(Integer id) {
		this.concreteRepository.deleteById(id);
	}
}
