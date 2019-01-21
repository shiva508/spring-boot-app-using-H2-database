package com.example.demo.findById;

import java.util.List;

import com.example.demo.model.PersonFindById;

public interface PersonFindByIdDao {
	public void savePerson(PersonFindById personFindById);
	public PersonFindById updatePerson(PersonFindById personFindById);
	public PersonFindById findPersonByID(Integer id);
	public List<PersonFindById> getAllPersons();

}
