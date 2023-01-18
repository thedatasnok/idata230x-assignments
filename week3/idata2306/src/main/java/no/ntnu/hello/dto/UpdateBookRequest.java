package no.ntnu.hello.dto;

public record UpdateBookRequest(
  String title,
  int year,
  int numberOfPages
) {}
