package kodlama.io.rentACar.webApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class AuthTestsController {

    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("hosgeldiniz.");
    }

}
