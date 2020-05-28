package ru.gothmog.ws.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer",schema = "book_dbo",
        indexes = {@Index(name = "unq_customer_email", columnList = "email", unique = true)}
)
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "email", length = 64)
    private String email;
    @Column(name = "first_name",length = 100)
    private String firstName;
    @Column(name = "last_name",length = 100)
    private String lastName;
    @Column(name = "address",length = 128)
    private String address;
    @Column(name = "city",length = 32)
    private String city;
    @Column(name = "country",length = 64)
    private String country;
    @Column(name = "registr_on")
    private LocalDateTime registrOn;
    @Column(name = "pswd", length = 16)
    private String password;
    @Column(name = "phone",length = 15)
    private String phone;
    @Column(name = "zipcode",length = 6)
    private String zipcode;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();

    public String getFullName (){
        return getFirstName() + " " + getLastName();
    }
}
