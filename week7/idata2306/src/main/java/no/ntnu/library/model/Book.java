package no.ntnu.library.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "book")
public class Book {

  public static final String PRIMARY_KEY = "book_id";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = Book.PRIMARY_KEY)
  private Long id;

  @Setter
  @Column(name = "title")
  private String title;
  
  @Setter
  @Column(name = "year_published")
  private Integer year;
  
  @Setter
  @Column(name = "pages")
  private Integer numberOfPages;
  
  @ManyToMany
  @JoinTable(
    name = "book_author",
    joinColumns = @JoinColumn(
      name = "fk_book_id",
      referencedColumnName = Book.PRIMARY_KEY
    ),
    inverseJoinColumns = @JoinColumn(
      name = "fk_author_id",
      referencedColumnName = Author.PRIMARY_KEY
    )
  )
  private Set<Author> authors = new HashSet<>();

  @OneToMany(mappedBy = "book")
  private List<Tag> tags;

  public Book(String title, Integer year, Integer numberOfPages) { 
    this.title = title;
    this.year = year;
    this.numberOfPages = numberOfPages;
  }

}