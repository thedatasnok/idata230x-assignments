package no.ntnu.hello.model;

public record Author(
  int id,
  String firstName,
  String lastName,
  int birthYear
) {}
