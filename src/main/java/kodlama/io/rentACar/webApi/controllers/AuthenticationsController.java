package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.AuthenticationService;
import kodlama.io.rentACar.business.requests.CreateUserRequest;
import kodlama.io.rentACar.business.requests.UserRequest;
import kodlama.io.rentACar.business.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationsController {
    private final AuthenticationService authenticationService;
    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody CreateUserRequest createUserRequest){
        log.info("buraya düştü");
        return ResponseEntity.ok(authenticationService.save(createUserRequest));
    }
    @PostMapping("/auth")
    public ResponseEntity<UserResponse> auth(@RequestBody UserRequest userRequest){
        log.info("buraya düştü",userRequest.getUsername(),userRequest.getPassword());
        return ResponseEntity.ok(authenticationService.auth(userRequest));
    }
}
