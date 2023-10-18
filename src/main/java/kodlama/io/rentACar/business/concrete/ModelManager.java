package kodlama.io.rentACar.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concrete.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public SuccessDataResult<List<GetAllModelsResponse>> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelsResponse> getAllModelsResponses = 
				models.stream().map(model -> this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllModelsResponse>>(getAllModelsResponses);
	}
	@Override
	public Result add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		modelRepository.save(model);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		modelRepository.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
		modelRepository.save(model);
		return new SuccessResult();
	}

	@Override
	public GetAllModelsResponse getByName(String modelName) {
		Model model = this.modelRepository.getByName(modelName);
		return this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class);
	}
	@Override
	public GetAllModelsResponse getByNameAndBrandId(String modelName,int brandId) {
		Model models = this.modelRepository.getByNameAndBrand_Id(modelName, brandId);
		//GetAllModelsResponse.class alanı null olursa oluşacak hata-- destinationType cannot be null
		return this.modelMapperService.forResponse().map(models, GetAllModelsResponse.class);
	}
	@Override
	public SuccessDataResult<List<GetAllModelsResponse>> getByNameOrBrandId(String modelName, int brandId) {
		List<Model> models = this.modelRepository.getByNameOrBrand_Id(modelName, brandId);
		List<GetAllModelsResponse> getAllModelsResponses= models.stream().map(m -> modelMapperService.forResponse().map(m, GetAllModelsResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllModelsResponse>>(getAllModelsResponses);
	}

}
