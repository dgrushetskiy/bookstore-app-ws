package ru.gothmog.ws.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "book_dbo",
        indexes = {@Index(name = "unq_user_email", columnList = "email", unique = true)}
        )
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @NaturalId
    @Column(name = "email", length = 30)
    private String email;
    @Column(name = "pswd", length = 16)
    private String password;
    @Column(name = "first_name",length = 50)
    private String firstName;
    @Column(name = "last_name",length = 50)
    private String lastName;

    public String getFullName (){
        return getFirstName() + " " + getLastName();
    }
}
