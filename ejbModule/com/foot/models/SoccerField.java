package com.foot.models;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SoccerField {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	private String description;
	private float latitude;
	private float longitude;
	private int capacity;
	private BigDecimal price;
	@Enumerated(value = EnumType.STRING)
	private Rank rank;
	@OneToMany
	@JoinColumn(name = "soccer_field_id")
	private Set<Photo> photos;
	@ManyToOne
	private Zone zone;

	public enum Rank {
		STAR_3, STAR_2, STAR_1
	}
}
