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
//@Table(name = "product")
@Table(name = "post")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

	
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + "]";
	}

	@XmlElement
	private String title;
	

	@XmlElement
	private String body;

/*	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
