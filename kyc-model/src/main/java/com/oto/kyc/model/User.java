/**
 * 
 */
package com.oto.kyc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.oto.kyc.model.base.IdentifiedEntity;

/**
 * @author otocon
 *
 */
@Entity
@Table(name = "t_user")
public class User implements IdentifiedEntity<Integer>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -477495697277420846L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="user_name")
	@NotNull
	@Size(min = 8, max = 50)
	private String username;
	
	@Column(name = "password")
	@NotNull
	@Size(min = 8, max = 16)
	private String password;
	
	@Column(name = "first_name")
	@Size(max = 50)
	private String firstName;
	
	@Column(name = "last_name")
	@Size(max = 50)
	private String lastName;
	
	@Column(name = "email")
	@NotNull
	@Size(max = 100)
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + firstName
				+ ", last_name=" + lastName + ", email=" + email + "]";
	}

}
