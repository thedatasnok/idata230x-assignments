package no.ntnu.library.dto;

public record CreateBookRequest(
  String title,
  int year,
  int numberOfPages
) {}
