package no.ntnu.hello.dto;

public record CreateBookRequest(
  String title,
  int year,
  int numberOfPages
) {}
