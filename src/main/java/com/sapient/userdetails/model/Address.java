package com.sapient.userdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
// @Table(name = "product")
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", suit=" + suit + ", city=" + city + "]";
	}

	@XmlElement
	private String street;


	@XmlElement
	private String suit;


	@XmlElement
	private String city;

	public int getUid() {
		return id;
	}

	public void setUid(int uid) {
		this.id = uid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
