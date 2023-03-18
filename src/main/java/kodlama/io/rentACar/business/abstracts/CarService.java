package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;

public interface CarService {

	List<GetAllCarsResponse> getAll();
	List<GetAllCarsResponse> getAll(int pageNo, int pageSize);
	public void add(CreateCarRequest createCarRequest);
	
	
	
}
