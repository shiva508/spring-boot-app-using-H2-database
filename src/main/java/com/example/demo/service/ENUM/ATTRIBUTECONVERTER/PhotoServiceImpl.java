package com.example.demo.service.ENUM.ATTRIBUTECONVERTER;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.ENUM.ATTRIBUTECONVERTER.Photo;
import com.example.demo.repository.ENUM.ATTRIBUTECONVERTER.PhotoRepository;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	private PhotoRepository photoRepository;

	@Override
	public Photo savePhoto(Photo photo) {
		return photoRepository.save(photo);
	}

	@Override
	public Photo getPhotosByCaption(String caption) {
		return photoRepository.getPhotosByCaption(caption);
	}

}
