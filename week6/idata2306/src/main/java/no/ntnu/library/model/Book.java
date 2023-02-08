package no.ntnu.library.model;

public record Book(
  long id,
  String title,
  int year,
  int numberOfPages
) {}
