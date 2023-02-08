package no.ntnu.library.model;

public record Author(
  int id,
  String firstName,
  String lastName,
  int birthYear
) {}
