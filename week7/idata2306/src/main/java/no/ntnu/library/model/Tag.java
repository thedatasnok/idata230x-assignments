package no.ntnu.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "book_tag")
public class Tag {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_tag_id")
  private Long id;

  @Setter
  @Column(name = "tag_name")
  private String name;

  @Setter
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "fk_book_id", referencedColumnName = Book.PRIMARY_KEY)
  private Book book;

  public Tag(String name, Book book) {
    this.name = name;
    this.book = book;
  }

}
