package com.zh.sergei.specalc.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Table(name = "spender")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class SpenderEntity {

  @Id
  String id;

  @OneToMany(mappedBy = "spender")
  List<SpendingEntity> spendings;

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
