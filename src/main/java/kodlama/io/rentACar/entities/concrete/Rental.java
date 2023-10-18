package kodlama.io.rentACar.entities.concrete;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "rentals")
public class Rental {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="receipt_date")
    private Timestamp receipt_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="return_date")
    private Timestamp return_date;

    @Column(name = "total_cost")
    private BigDecimal total_cost;

}
