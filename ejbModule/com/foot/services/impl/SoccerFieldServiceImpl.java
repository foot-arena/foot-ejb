package com.foot.services.impl;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;

import com.foot.models.SoccerField;
import com.foot.services.SoccerFieldService;

@Stateless
public class SoccerFieldServiceImpl implements SoccerFieldService {

	@PersistenceContext
	private EntityManager eManager;
	
	@Override
	@PermitAll
	public SoccerField add(SoccerField o) {
		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public SoccerField update(SoccerField o) {
		if (eManager.find(SoccerField.class, o) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public void delete(SoccerField o) {
		if (eManager.find(SoccerField.class, o) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.remove(o);
	}

	@Override
	@PermitAll
	public List<SoccerField> findAll() {
		Query query = eManager.createQuery("from SoccerField");
		return query.getResultList();
	}

	@Override
	@PermitAll
	public SoccerField findById(int id) {
		SoccerField found = eManager.find(SoccerField.class, id);
		if (found == null) {
			new NotFoundException("Entity not found!");
		}

		return found;
	}

}
