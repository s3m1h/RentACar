package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateUserRequest;
import kodlama.io.rentACar.business.requests.UserRequest;
import kodlama.io.rentACar.business.responses.UserResponse;

public interface AuthenticationService {

    public UserResponse save(CreateUserRequest createUserRequest);

    public UserResponse auth(UserRequest userRequest);
}
