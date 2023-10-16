package kodlama.io.rentACar.entities.concrete;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Data
@Table(name = "Locations")
public class Location {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "location")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Rental> rentals;
}
