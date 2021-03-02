package com.firebaselearn.firebaseexample.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@NoArgsConstructor

public class QRModel 
{
	private Long uuid;
	private String resto_name;
	private String type;
	private String table_number;
	private String location;
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getResto_name() {
		return resto_name;
	}
	public void setResto_name(String resto_name) {
		this.resto_name = resto_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTable_number() {
		return table_number;
	}
	public void setTable_number(String table_number) {
		this.table_number = table_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
