package kodlama.io.rentACar.entities.concrete;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone_number;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="birtdate")
    private Date birthdate;

    @OneToMany(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Rental> rentals;

}
