package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.entities.concrete.Model;

public interface ModelService {
	SuccessDataResult<List<GetAllModelsResponse>> getAll();
	GetAllModelsResponse getByNameAndBrandId(String modelName, int brandId);
	SuccessDataResult<List<GetAllModelsResponse>> getByNameOrBrandId(String modelName, int brandId);
	GetAllModelsResponse getByName(String modelName);
	Result add(CreateModelRequest createModelRequest);
	Result delete(int id);
	Result update(UpdateModelRequest updateModelRequest);
	
}
 