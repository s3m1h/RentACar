package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private Boolean state;
    private String phone_number;
    private Date birthdate;
}
