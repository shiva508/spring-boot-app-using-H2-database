package com.example.demo.repository.ENUM.ATTRIBUTECONVERTER;

import java.util.List;

import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Caption;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Photo;

public interface CustomPhotoRepository {
public List<Photo> getPhotos(Caption caption);
public Photo getPhotosByCaption(String caption);
}
