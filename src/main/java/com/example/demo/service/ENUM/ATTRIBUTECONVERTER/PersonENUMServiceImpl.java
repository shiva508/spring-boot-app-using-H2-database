package com.example.demo.service.ENUM.ATTRIBUTECONVERTER;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.PersonENUM;
import com.example.demo.repository.ENUM.ATTRIBUTECONVERTER.PersonENUMRepository;
@Service
@Transactional
public class PersonENUMServiceImpl implements PersonENUMService {
	@Autowired
	private PersonENUMRepository personENUMRepository;
	@Override
	public PersonENUM savePersonENUM(PersonENUM personENUM) {
		return personENUMRepository.save(personENUM);
	}
}
