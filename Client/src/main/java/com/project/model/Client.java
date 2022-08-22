package com.project.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "client")
@Setter
@Getter
public class Client {
	private String _id;
	@NotNull
	private String name;
	@NotNull
	private String dni_ruc;
	@NotNull
	private TypeClient typeClient;
}
