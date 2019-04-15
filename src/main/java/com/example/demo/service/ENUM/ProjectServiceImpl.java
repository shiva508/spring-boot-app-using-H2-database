package com.example.demo.service.ENUM;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ENUM.Project;
import com.example.demo.repository.ENUM.ProjectRepository;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {
		
		return projectRepository.save(project);
	}

}
