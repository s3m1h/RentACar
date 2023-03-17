package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController // annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping()
	public DataResult<List<GetAllBrandsResponse>>  getAll(){
		DataResult<List<GetAllBrandsResponse>> result = brandService.getAll();
		if(result.isSuccess()) {
			return result;
		}
		return null;
	}
	@GetMapping("/{id}")
	public DataResult<GetByIdBrandResponse> getById(int id){
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		Result result = brandService.add(createBrandRequest);
		return result;
	}
	@DeleteMapping("/{id}")
	public Result delete(int id) {
		return brandService.delete(id);
	}
	@PutMapping()
	public Result update(UpdateBrandRequest updateBrandRequest) {
		return brandService.update(updateBrandRequest);
	}
	
}
