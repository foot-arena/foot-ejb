package com.foot.models;

import java.io.Serializable;
 
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ReservationSoccerField implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Builder.Default
	private SoccerFieldReservationKey id = new SoccerFieldReservationKey();
	
	@ManyToOne
	@MapsId("soccerFieldId")
	private SoccerField soccerField;

	@ManyToOne
	@MapsId("reservationId")
	private Reservation reservation;
	
	private Date date;
}
