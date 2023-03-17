package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.aspectj.asm.AsmManager.ModelInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;
	
	@GetMapping
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
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
	public List<GetAllModelsResponse> getByNameOrBrandId(@RequestParam("modelName") String modelName,@RequestParam("brandId") int brandId) {
		return modelService.getByNameOrBrandId(modelName, brandId);
	}
}
