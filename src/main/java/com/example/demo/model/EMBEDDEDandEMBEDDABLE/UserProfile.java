package com.example.demo.model.EMBEDDEDandEMBEDDABLE;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USER_PROFILE")
@NoArgsConstructor
@Getter
@Setter

public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer userProfileId;
	private String email;
	@Embedded
	private UserName userName;
	@Embedded
	private UserPhoneNumber userPhoneNumber;
	@Embedded
	@AttributeOverrides(value= {
			@AttributeOverride(name="addressLine1",column=@Column(name ="house_number")),
			@AttributeOverride(name="addressLine2",column=@Column(name="street"))
	})
	private Address userAddress;
	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", email=" + email + ", userName=" + userName
				+ ", userPhoneNumber=" + userPhoneNumber + ", userAddress=" + userAddress + "]";
	}

}
