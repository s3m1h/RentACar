package kodlama.io.rentACar.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concrete.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public DataResult<List<GetAllBrandsResponse>> getAll() {
		var brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse = 
				brands.stream().map(brand->this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		
		return new SuccessDataResult<List<GetAllBrandsResponse>>(brandsResponse);
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brandRepository.save(brand);
		
		
		return new SuccessResult("başarılı bir şekilde eklendi.");
	}

	@Override
	public DataResult<GetByIdBrandResponse>  getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse getByIdBrandResponse = 
				this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return new SuccessDataResult<GetByIdBrandResponse>(getByIdBrandResponse);
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		brandRepository.save(brand);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		brandRepository.deleteById(id);
		return new SuccessResult();
	}


}