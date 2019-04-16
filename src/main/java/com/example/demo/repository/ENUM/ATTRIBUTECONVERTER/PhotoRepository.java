package com.example.demo.repository.ENUM.ATTRIBUTECONVERTER;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Photo;
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>,CustomPhotoRepository {

}
