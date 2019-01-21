package com.example.demo.findById;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.PersonFindById;
@Service
@Transactional
public class PersonFindByIdServiceImpl implements PersonFindByIdService{
	@Autowired
	PersonFindByIdDao personFindByIdDao;

	@Override
	public void savePerson(PersonFindById personFindById) {
		personFindByIdDao.savePerson(personFindById);
		
	}

	@Override
	public PersonFindById updatePerson(PersonFindById personFindById) {
		
		return personFindByIdDao.updatePerson(personFindById);
	}

	@Override
	public PersonFindById findPersonByID(Integer id) {
		
		return personFindByIdDao.findPersonByID(id);
	}

	@Override
	public List<PersonFindById> getAllPersons() {
		return personFindByIdDao.getAllPersons();
	}
}
