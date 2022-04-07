package com.learning.SpringBootAOP.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "countries")
@Getter
@Setter
@ToString
public class Country {

  @Id
  private Long id;
  private String name;
}
