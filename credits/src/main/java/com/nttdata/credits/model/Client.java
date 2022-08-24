package com.nttdata.credits.model;

import lombok.Data;

@Data
public class Client {
	private Long ruc_dni;
	private String name;
	private Type types;
}
