package com.zh.sergei.specalc.model.entity;

import com.zh.sergei.specalc.model.Spender;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "spending")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpendingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @OneToOne
  @JoinColumn(name = "spender_id")
  SpenderEntity spender;

  @Column(name = "name")
  String name;
}
