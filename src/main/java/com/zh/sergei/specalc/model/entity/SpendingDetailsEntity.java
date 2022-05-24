package com.zh.sergei.specalc.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "spending_details")
@Entity
public class SpendingDetailsEntity {

  @Id
  long id;

  @OneToOne
  @JoinColumn(name = "spending_id")
  SpendingEntity spending;

  @Column(name = "shop_name")
  String shopName;

//  ShopEntity shop;




}
