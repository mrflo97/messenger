package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.BaseEntity;
import com.fwindhagauer.messenger.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class BaseController<TService extends BaseService, TEntity extends BaseEntity> {
	protected TService concreteService;

	@Autowired
	public BaseController(TService concreteService) {
		this.concreteService = concreteService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List getEntities() {
		return this.concreteService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TEntity getSingleEntity(@PathVariable Integer id) {
		return (TEntity) this.concreteService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity addEntity(@RequestBody TEntity tEntity) {
		return ResponseEntity.ok(this.concreteService.saveEntity(tEntity));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteEntity(@PathVariable Integer id) {
		this.concreteService.delete(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public TEntity editEntity(@RequestBody TEntity tEntity) {
		return (TEntity) this.concreteService.saveEntity(tEntity);
	}
}