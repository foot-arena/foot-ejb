package com.foot.services.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;

import com.foot.models.Client;
import com.foot.services.ClientService;

@Stateless
public class ClientServiceImpl implements ClientService {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	@PermitAll
	public Client add(Client o) {
		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Client update(Client o) {
		if (eManager.find(Client.class, o) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public void delete(int id) {
		if (eManager.find(Client.class, id) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.remove(id);
	}

	@Override
	@PermitAll
	public List<Client> findAll() {
		Query query = eManager.createQuery("from Client");
		return query.getResultList();
	}

	@Override
	@PermitAll
	public Client findById(int id) {
		Client found = eManager.find(Client.class, id);
		if (found == null) {
			throw new NotFoundException("Entity not found!");
		}

		return found;
	}

	@Override
	public Client findByEmail(String email) {

		return (Client) eManager.createNativeQuery("FROM Client c WHERE c.email = :email")
				.setParameter("email", email)
				.getSingleResult();
	}
}
