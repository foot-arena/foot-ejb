package com.foot.models;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReservationSoccerField {
	@EmbeddedId
	private SoccerFieldReservationKey id;
	
	@ManyToOne
	@MapsId("soccer_field_id")
	private SoccerField soccerField;

	@ManyToOne
	@MapsId("reservation_id")
	private Reservation reservation;
	
	private Date date;
}
