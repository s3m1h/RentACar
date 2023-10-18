package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.UserRoleService;
import kodlama.io.rentACar.business.requests.CreateUserRoleRequest;
import kodlama.io.rentACar.business.requests.UpdateUserRoleRequest;
import kodlama.io.rentACar.business.responses.GetAllUserRoleResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.UserRoleRepository;
import kodlama.io.rentACar.entities.concrete.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRoleManager implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public SuccessDataResult<List<GetAllUserRoleResponse>> getAll() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<GetAllUserRoleResponse> result = userRoles.stream()
                .map(userRole ->modelMapperService.forResponse()
                        .map(userRole, GetAllUserRoleResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllUserRoleResponse>>(result);
    }

    @Override
    public Result add(CreateUserRoleRequest createUserRoleRequest) {
        userRoleRepository.save(this.modelMapperService.forRequest().map(createUserRoleRequest, UserRole.class));
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateUserRoleRequest updateUserRoleRequest) {
        userRoleRepository.save(modelMapperService.forRequest().map(updateUserRoleRequest,UserRole.class));
        return new SuccessResult();
    }
}
