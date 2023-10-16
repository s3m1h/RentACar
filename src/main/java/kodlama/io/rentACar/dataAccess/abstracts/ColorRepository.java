package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concrete.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color,Integer> {
}
