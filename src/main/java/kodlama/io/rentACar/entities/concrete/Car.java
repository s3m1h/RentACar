package kodlama.io.rentACar.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "plate", unique = true)
	private String plate;
	
	@Column(name = "dailyPrice")
	private double dailyPrice;

	@Column(name = "state")
	private boolean state;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@OneToMany(mappedBy = "car")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	List<Rental> rentals;
}
