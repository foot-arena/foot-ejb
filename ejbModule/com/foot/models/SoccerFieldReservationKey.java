package com.foot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SoccerFieldReservationKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "soccerfield_id")
	private int soccerFieldId;
	@Column(name = "reservation_id")
	private int reservationId;
}
