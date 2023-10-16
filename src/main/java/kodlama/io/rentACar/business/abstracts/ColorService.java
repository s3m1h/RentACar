package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateColorRequest;
import kodlama.io.rentACar.business.responses.GetAllColorResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.entities.concrete.Color;

import java.util.List;

public interface ColorService {

    public Result add(CreateColorRequest createColorRequest);
    public DataResult<List<GetAllColorResponse>> getAll();
}
