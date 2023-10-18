package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateUserRoleRequest;
import kodlama.io.rentACar.business.requests.UpdateUserRoleRequest;
import kodlama.io.rentACar.business.responses.GetAllUserRoleResponse;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.entities.concrete.User;
import kodlama.io.rentACar.entities.concrete.UserRole;

import java.util.List;

public interface UserRoleService {
    SuccessDataResult<List<GetAllUserRoleResponse>> getAll();
    Result add(CreateUserRoleRequest createUserRoleRequest);
    Result update(UpdateUserRoleRequest updateUserRoleRequest);

}
