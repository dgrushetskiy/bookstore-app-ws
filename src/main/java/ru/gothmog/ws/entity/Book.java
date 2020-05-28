package ru.gothmog.ws.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book",schema = "book_dbo",
        indexes = {@Index(name = "unq_book_isbn", columnList = "isbn", unique = true)}
)
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "title",length = 128)
    private String title;
    @Column(name = "isbn",length = 20)
    private String isbn;
    @Column(name = "description",length = 4096)
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "publish_date")
    private LocalDate publishDate;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
    private byte[] image;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "fk_book_author"))
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_book_category"))
    private Category category;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails = new HashSet<>();
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();
}
