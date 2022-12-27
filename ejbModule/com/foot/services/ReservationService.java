package com.foot.services;


import java.util.List;

import com.foot.models.Reservation;
import com.foot.models.ReservationSoccerField;

public interface ReservationService extends CrudService<Reservation> {

	Reservation add(Reservation o, List<ReservationSoccerField> fieldsReservations);
	List<ReservationSoccerField> findFieldsReservationById(int id);
}
