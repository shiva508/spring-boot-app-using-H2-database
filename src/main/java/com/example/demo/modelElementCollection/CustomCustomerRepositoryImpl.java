package com.example.demo.modelElementCollection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c JOIN FETCH c.phoneNumbers",
				Customer.class);
		List<Customer> customers=entityManager.createQuery("Select t from Customer t").getResultList();
		return customers;
	}

}
