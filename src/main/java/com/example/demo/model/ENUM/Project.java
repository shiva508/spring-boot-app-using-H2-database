package com.example.demo.model.ENUM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PROJECT")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="PROJECT_ID")
	private Integer projectId;
	@Column(name="PROJECT_NAME")
	private String projectName;
	@Enumerated
	@Column(name="PROJECT_STATUS")
	private ProjectStatus projectStatus;
}
