package kodlama.io.rentACar.business.concrete;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concrete.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService{
	
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarsResponse> getAllCarsResponses = cars.stream().map(c->this.modelMapperService.forResponse().map(c, GetAllCarsResponse.class)).collect(Collectors.toList());
		
		return getAllCarsResponses;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public List<GetAllCarsResponse> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		List<Car> cars = this.carRepository.findAll(pageable).getContent();
		
		return cars.stream().map(c->this.modelMapperService.forResponse().map(c, GetAllCarsResponse.class)).collect(Collectors.toList());
	}

}
