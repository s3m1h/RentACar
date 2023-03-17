package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	GetAllModelsResponse getByNameAndBrandId(String modelName, int brandId);
	List<GetAllModelsResponse> getByNameOrBrandId(String modelName, int brandId);
	GetAllModelsResponse getByName(String modelName);
	public void add(CreateModelRequest createModelRequest);
	
	
}
 