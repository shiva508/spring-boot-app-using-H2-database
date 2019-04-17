package com.example.demo.model.GeneratedProperties.GENERATED;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.tuple.ValueGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PersonCustomGenerator {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String firstName;

	private String lastName;
	@GeneratorType(type=LoggedUserGenerator.class,when=GenerationTime.INSERT)
	private String createdBy;
	@GeneratorType(type=LoggedUserGenerator.class,when=GenerationTime.ALWAYS)
	private String updatedBy;
	
	public static class CurrentUser {
		public static final CurrentUser INSTANCE=new CurrentUser();
		private static final ThreadLocal<String> storage =new ThreadLocal<String>();
		public void login(String user) {
			storage.set(user);
		}
		public void logout() {
			storage.remove();
		}
		public String get() {
			return storage.get();
		}
	}
	public static class LoggedUserGenerator implements ValueGenerator<String>{

		@Override
		public String generateValue(Session session, Object owner) {
			return CurrentUser.INSTANCE.get();
		}
		
	}
}
