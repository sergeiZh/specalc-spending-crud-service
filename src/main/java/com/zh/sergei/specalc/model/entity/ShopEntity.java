package com.zh.sergei.specalc.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopEntity {

  @Id
  String id;

  @Column(name = "name")
  String name;

  @Column(name = "type")
  String type;

  @OneToMany(mappedBy = "shop")
  List<SpendingEntity> spendingEntities;
}
