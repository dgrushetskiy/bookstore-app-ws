package ru.gothmog.ws.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category", schema = "book_dbo",
        indexes = {@Index(name = "unq_category_name", columnList = "name", unique = true)}
)
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", length = 100)
    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    public Category() {
    }

    public Category(String name){
        this.name = name;
    }

    public Category(String name, Set<Book> books){
        this.name = name;
        this.books = books;
    }
}
