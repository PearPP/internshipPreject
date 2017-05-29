//package com.oceantest.services.user.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@SuppressWarnings("serial")
//@Table(name="users")
//@Entity
//@NamedQueries({
//	@NamedQuery(
//		name = "UserEntity.findAll", 
//		query = " SELECT o FROM com.oceantest.services.user.model.UserEntity o " 
//	)
//})
//public class UserEntity implements Serializable {
//	
//		@Id
////		@GeneratedValue(strategy=GenerationType.AUTO)
//		@Column(name="id")
//		private int id;
//		@Column(name="fullname")
//		private String fullname;
//		@Column(name="username")
//		private String username;
//		
//		public UserEntity(){}
//		
//		public UserEntity(String fullname, String username){
//			this.fullname = fullname;
//			this.username = username;
//		}
//		public int getId() {
//			return id;
//		}
//		public void setId(int id) {
//			this.id = id;
//		}
//		public String getFullname() {
//			return fullname;
//		}
//		public void setFullname(String fullname) {
//			this.fullname = fullname;
//		}
//		public String getUsername() {
//			return username;
//		}
//		public void setUsername(String username) {
//			this.username = username;
//		}
//
//}
