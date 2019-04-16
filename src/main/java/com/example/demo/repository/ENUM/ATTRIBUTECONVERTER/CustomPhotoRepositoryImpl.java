package com.example.demo.repository.ENUM.ATTRIBUTECONVERTER;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.metamodel.Type;

import org.hibernate.SessionFactory;

import org.hibernate.metamodel.spi.MetamodelImplementor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Caption;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Photo;

@Repository
public class CustomPhotoRepositoryImpl implements CustomPhotoRepository {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Photo> getPhotos(Caption caption) {
		return null;
	}

	@Override
	public Photo getPhotosByCaption(String caption) {
		/*
		 * SessionFactory
		 * sessionFactory=entityManager.getEntityManagerFactory().unwrap(SessionFactory.
		 * class); MetamodelImplementor metamodelImplementor=(MetamodelImplementor)
		 * sessionFactory.getMetamodel(); org.hibernate.type.Type captionType
		 * =metamodelImplementor.entityPersister(Photo.class.getName()).getPropertyType(
		 * "caption"); Photo photo = (Photo) entityManager.createQuery( "select p " +
		 * "from Photo p " + "where upper(caption) = upper(:caption) ", Photo.class )
		 * .unwrap( Query.class ) .setParameter( "caption", new
		 * Caption("Nicolae Grigorescu"), captionType) .getSingleResult();
		 */
		//test
		Photo photo1=entityManager.createQuery("select p from Photo p where upper(caption)=upper(:caption) ",Photo.class)
				.setParameter("caption", caption)
				.getSingleResult();
		return photo1;
	}
	
}
