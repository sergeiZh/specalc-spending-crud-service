package com.zh.sergei.specalc.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Id;

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
}
