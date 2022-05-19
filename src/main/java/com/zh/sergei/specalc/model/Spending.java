package com.zh.sergei.specalc.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Spending {

  String spenderId;

  String name;

  long total;
}
