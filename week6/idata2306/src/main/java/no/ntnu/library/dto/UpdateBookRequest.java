package no.ntnu.library.dto;

public record UpdateBookRequest(
  String title,
  int year,
  int numberOfPages
) {}
