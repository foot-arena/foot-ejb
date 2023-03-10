package com.foot.services;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CrudService<T> {
	T add(T t);
	T update(T t);
	void delete(int id);
	List<T> findAll();
	T findById(int id);
}
