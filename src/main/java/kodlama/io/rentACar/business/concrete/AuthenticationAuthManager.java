package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.AuthenticationService;
import kodlama.io.rentACar.business.requests.CreateUserRequest;
import kodlama.io.rentACar.business.requests.UserRequest;
import kodlama.io.rentACar.business.responses.UserResponse;
import kodlama.io.rentACar.core.config.JwtService;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;
import kodlama.io.rentACar.entities.concrete.User;
import kodlama.io.rentACar.entities.concrete.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationAuthManager implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserResponse save(CreateUserRequest createUserRequest) {

        User user = User.builder()
                .username(createUserRequest.getUsername())
                .firstname(createUserRequest.getFirstname())
                .lastname(createUserRequest.getLastname())
                .email(createUserRequest.getEmail())
                .role(UserRole.USER)
                .state(createUserRequest.getState())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .phone_number(createUserRequest.getPhone_number())
                .build();

        /*
        User user = modelMapperService.forRequest().map(createUserRequest,User.class);
        userRepository.save(user);*/
        userRepository.save(user);
        System.out.println("user kaydedildi");
        var jwtToken = jwtService.generateToken(user);
        return UserResponse.builder().token(jwtToken).build();
    }

    @Override
    public UserResponse auth(UserRequest userRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getUsername(),userRequest.getPassword()));
        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
}
