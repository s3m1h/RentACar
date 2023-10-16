package kodlama.io.rentACar.entities.concrete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserRoles")
public class UserRole {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;

}
