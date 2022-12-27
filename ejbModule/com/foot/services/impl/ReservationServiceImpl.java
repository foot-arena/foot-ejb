package com.foot.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;

import com.foot.models.Reservation;
import com.foot.models.ReservationSoccerField;
import com.foot.models.SoccerField;
import com.foot.services.ReservationService;

@Stateless
public class ReservationServiceImpl implements ReservationService {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	@PermitAll
	public Reservation add(Reservation o) {
		eManager.persist(o);
		return o;
	}

	@Override
	@PermitAll
	public Reservation update(Reservation o) {
		if (eManager.find(Reservation.class, o.getId()) == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.merge(o);
		return o;
	}

	@Override
	@PermitAll
	public void delete(int id) {
		Reservation city = eManager.find(Reservation.class, id);
		if (city == null) {
			new NotFoundException("Entity not found!");
		}

		eManager.remove(city);
	}

	@Override
	@PermitAll
	public List<Reservation> findAll() {
		Query query = eManager.createQuery("from Reservation");
		return query.getResultList();
	}

	@Override
	@PermitAll
	public Reservation findById(int id) {
		Reservation found = eManager.find(Reservation.class, id);
		if (found == null) {
			new NotFoundException("Entity not found!");
		}

		return found;
	}

	@Override
	@PermitAll
	public Reservation add(Reservation o, List<ReservationSoccerField> fieldsReservations) {
		eManager.persist(o);
		fieldsReservations.forEach(f -> {
			f.setReservation(o);
			eManager.persist(f);
		});
		return o;
	}

	@Override
	@PermitAll
	public List<ReservationSoccerField> findFieldsReservationById(int id) {
//		Query query = eManager.createQuery("from ReservationSoccerField", ReservationSoccerField.class);
//
//		query.setParameter(1, id);
//		return query.getResultList();
		return eManager.createQuery("from ReservationSoccerField", ReservationSoccerField.class).getResultList();
	}
}
