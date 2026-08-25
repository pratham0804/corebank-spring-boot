package com.corebank.entity;

// import org.hibernate.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

   

  private String name;
   

  private String email;

   

  public Customer(){
//  Hibernate reads a database row and creates a Java object from it. The no-argument constructor helps Hibernate create that object.
  }

  public Customer(String name,String email){
      this.name = name;
      this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
     this.name = name;
  }



  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
     this.email = email;
  }

   
}
