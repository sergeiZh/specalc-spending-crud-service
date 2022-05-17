package com.zh.sergei.specalc.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "spender")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class SpenderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  long id;

  @OneToOne(mappedBy = "spender")
  SpendingEntity externalId;

  @Column(name = "first_name",
		  nullable = false,
		  columnDefinition = "TEXT"
  )
  String firstName;

  @Column(name = "last_name",
		  nullable = false,
		  columnDefinition = "TEXT"
  )
  String lastName;
}
