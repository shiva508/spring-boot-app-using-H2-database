package com.example.demo.model.EMBEDDEDandEMBEDDABLE;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserName {
private String firstName;
private String middleName;
private String lastName;
}
