package com.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "typeClient")
@Getter
@Setter
public class TypeClient {
	@Id
	private String idType;
	private String description;
}
