package com.ayuayu.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class BaseServiceImpl<DOMAIN, ID extends Serializable> implements
		BaseService<DOMAIN, ID> {
	@Autowired
	protected CrudRepository<DOMAIN, ID> repository;

	@Override
	public DOMAIN findById(ID id) {
		return repository.findOne(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DOMAIN> findByIds(List<ID> ids) {
		return IteratorUtils.toList(repository.findAll(ids).iterator());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DOMAIN> findAll() {
		return IteratorUtils.toList(repository.findAll().iterator());
	}

	@Override
	public void delete(ID id) {
		repository.delete(id);
	}

	@Override
	public void delete(List<DOMAIN> domains) {
		repository.delete(domains);
	}

	@Override
	public void save(DOMAIN domain) {
		repository.save(domain);
	}

	@Override
	public void save(List<DOMAIN> domains) {
		repository.save(domains);
	}

}
