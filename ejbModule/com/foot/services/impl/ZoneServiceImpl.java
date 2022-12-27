package com.foot.services.impl;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;

import com.foot.models.Zone;
import com.foot.services.ZoneService;

@Stateless
public class ZoneServiceImpl implements ZoneService {
	
	@PersistenceContext
	private EntityManager eManager;

	@Override
	@PermitAll
	public Zone add(Zone o) {
		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Zone update(Zone o) {
		if (eManager.find(Zone.class, o.getId()) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.merge(o);
		return o;
	}

	@Override
	@PermitAll
	public void delete(int id) {
		Zone zone = eManager.find(Zone.class, id);
		if (zone == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.remove(zone);
	}

	@Override
	@PermitAll
	public List<Zone> findAll() {
		Query query = eManager.createQuery("from Zone");
		return query.getResultList();
	}

	@Override
	@PermitAll
	public Zone findById(int id) {
		Zone found = eManager.find(Zone.class, id);
		if (found == null) {
			new NotFoundException("Entity not found!");
		}

		return found;
	}

}
