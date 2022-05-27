package com.zh.sergei.specalc.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "spending")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpendingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @ManyToOne(fetch = FetchType.LAZY)
  SpenderEntity spender;

  @Column(name = "title")
  String title;

  @ManyToOne(fetch = FetchType.LAZY)
  ShopEntity shop;

  @Column(name = "total")
  Long total;

  @Column(name = "date")
  LocalDateTime date;


}
