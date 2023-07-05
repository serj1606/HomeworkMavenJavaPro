package org.hillel.mvc.entity;

import lombok.AllArgsConstructor;


import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
  UUID id = UUID.randomUUID();
  String name;
  double cost;
}

