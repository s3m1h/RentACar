package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
@CrossOrigin
public class CarsController {

	private CarService carService;
	
	@GetMapping("/getall")
	public List<GetAllCarsResponse> getAll(){
		return carService.getAll();
	}
	@GetMapping("/getallpages")
	public List<GetAllCarsResponse> getAll(int pageNo, int pageSize){
		return carService.getAll(pageNo,pageSize);
		}
	
	@PostMapping("/add")
	public void add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		carService.add(createCarRequest);
	}
}
