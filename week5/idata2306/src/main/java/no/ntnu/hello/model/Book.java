package no.ntnu.hello.model;

public record Book(
  int id,
  String title,
  int year,
  int numberOfPages
) {}
