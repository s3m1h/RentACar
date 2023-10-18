package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.entities.concrete.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
@CrossOrigin
public class ModelsController {
	private ModelService modelService;
	
	@GetMapping
	public SuccessDataResult<List<GetAllModelsResponse>> getAll(){
		var result = modelService.getAll();
		if(result.isSuccess()){
			return result;
		}
		return null;
	}
	@PostMapping
	public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		modelService.add(createModelRequest);
	}
	
	@GetMapping("/getByName")
	public GetAllModelsResponse getByName(@RequestParam String modelName) {
		return modelService.getByName(modelName);
	}
	@GetMapping("getByNameAndBrandId")
	public GetAllModelsResponse getByNameAndBrandId(@RequestParam String modelName,@RequestParam int brandId) {
		return modelService.getByNameAndBrandId(modelName, brandId);
	}
	@GetMapping("getByNameOrBrandId")
	public SuccessDataResult<List<GetAllModelsResponse>> getByNameOrBrandId(@RequestParam("modelName") String modelName, @RequestParam("brandId") int brandId) {
		var result = modelService.getByNameOrBrandId(modelName, brandId);
		if(result.isSuccess()){
			return result;
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public Result delete(int id){
		var result = modelService.delete(id);
		if(result.isSuccess()){
			return result;
		}
		return null;
	}
	@PutMapping
	public Result update(UpdateModelRequest updateModelRequest){
		var result = modelService.update(updateModelRequest);
		if(result.isSuccess()){
			return result;
		}
		return null;
	}
}
