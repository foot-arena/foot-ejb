package com.foot.services;

import com.foot.models.Client;

public interface ClientService extends CrudService<Client>{
	
	Client findByEmail(String email);
}
