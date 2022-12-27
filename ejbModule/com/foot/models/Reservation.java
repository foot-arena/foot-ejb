package com.foot.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Access(AccessType.FIELD)
@Entity
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
//	@OneToMany(mappedBy = "reservation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@Builder.Default
//	private Set<ReservationSoccerField> fieldsReservations = new HashSet<>();
	
//	public void addField(SoccerField field, Date date) {
//		ReservationSoccerField res = ReservationSoccerField.builder()
//				.reservation(this)
//				.soccerField(field)
//				.date(date)
//				.build();
//		fieldsReservations.add(res);
//	}
}
