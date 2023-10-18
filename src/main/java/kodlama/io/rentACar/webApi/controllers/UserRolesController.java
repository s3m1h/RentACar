package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.UserRoleService;
import kodlama.io.rentACar.business.requests.CreateUserRoleRequest;
import kodlama.io.rentACar.business.responses.GetAllUserRoleResponse;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user-roles")
@RequiredArgsConstructor
@CrossOrigin
public class UserRolesController {

    private final UserRoleService userRoleService;
    @PostMapping
    public Result add(@RequestBody @Valid CreateUserRoleRequest createUserRoleRequest){
        var result = userRoleService.add(createUserRoleRequest);
        if(result.isSuccess()){
            return result;
        }
        return null;
    }
    @GetMapping
    public SuccessDataResult<List<GetAllUserRoleResponse>> getAll(){
        var result = userRoleService.getAll();
        if(result.isSuccess()){
            return result;
        }
        return null;
    }
}
