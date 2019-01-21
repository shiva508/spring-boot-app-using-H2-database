package com.example.demo.findById;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PersonFindById;

@Repository
public class PersonFindByIdDaoImpl implements PersonFindByIdDao{
	@Autowired
	EntityManager entityManager;

	@Override
	public void savePerson(PersonFindById personFindById) {
		Session session=entityManager.unwrap(Session.class);
		session.persist(personFindById);
	}

	@Override
	public PersonFindById updatePerson(PersonFindById personFindById) {
		Session session=entityManager.unwrap(Session.class);
		return null;
	}

	@Override
	public PersonFindById findPersonByID(Integer id) {
	Session session=entityManager.unwrap(Session.class);
		return session.get(PersonFindById.class, id);
	}

	@Override
	public List<PersonFindById> getAllPersons() {
		List<PersonFindById> personList=entityManager.createQuery("SELECT * FROM PersonFindById", PersonFindById.class).getResultList();
		return personList;
	}
}
