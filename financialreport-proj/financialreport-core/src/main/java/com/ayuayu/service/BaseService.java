package com.ayuayu.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<DOMAIN, ID extends Serializable> {
	public DOMAIN findById(ID id);

	public List<DOMAIN> findByIds(List<ID> ids);

	public List<DOMAIN> findAll();

	public void delete(ID id);

	public void delete(List<DOMAIN> domains);

	public void save(DOMAIN domain);

	public void save(List<DOMAIN> domains);
}
