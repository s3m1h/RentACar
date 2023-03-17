package kodlama.io.rentACar.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelsResponse> getAllModelsResponses = 
				models.stream().map(model -> this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
		return getAllModelsResponses;
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		modelRepository.save(model);
		
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
	public List<GetAllModelsResponse> getByNameOrBrandId(String modelName, int brandId) {
		List<Model> models = this.modelRepository.getByNameOrBrand_Id(modelName, brandId);
		return models.stream().map(m -> modelMapperService.forResponse().map(m, GetAllModelsResponse.class)).collect(Collectors.toList());
	}

}
