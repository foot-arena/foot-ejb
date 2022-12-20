package com.foot.services.impl;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;

import com.foot.models.City;
import com.foot.services.CityService;
import com.foot.services.CrudService;

@Stateless
public class CityServiceImpl implements CityService {

	@PersistenceContext
	private EntityManager eManager;
	
	@Override
	@PermitAll
	public City add(City o) {
		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public City update(City o) {
		if (eManager.find(City.class, o) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public void delete(City o) {
		if (eManager.find(City.class, o) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.remove(o);
	}

	@Override
	@PermitAll
	public List<City> findAll() {
		Query query = eManager.createQuery("from City");
		return query.getResultList();
	}

	@Override
	@PermitAll
	public City findById(int id) {
		City found = eManager.find(City.class, id);
		if (found == null) {
			new NotFoundException("Entity not found!");
		}

		return found;
	}

}
