package com.foot.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Client {
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private String phone;
	private String email;
	private String password;
	@OneToMany
	@JoinColumn(name = "client_id")
	private Set<Reservation> reservations;
}
