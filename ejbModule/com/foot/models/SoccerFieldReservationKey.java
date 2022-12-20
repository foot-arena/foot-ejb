package com.foot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class SoccerFieldReservationKey implements Serializable {
	@Column(name = "soccer_field_id")
	private int soccerFieldId;
	@Column(name = "reservation_id")
	private int reservationId;
}
