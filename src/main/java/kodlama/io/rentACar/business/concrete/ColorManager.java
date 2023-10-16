package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.CreateColorRequest;
import kodlama.io.rentACar.business.responses.GetAllColorResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import kodlama.io.rentACar.dataAccess.abstracts.ColorRepository;
import kodlama.io.rentACar.entities.concrete.Color;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public Result add(CreateColorRequest createColorRequest) {
        return null;
    }

    @Override
    public DataResult<List<GetAllColorResponse>> getAll() {
        List<Color> result = colorRepository.findAll();
        List<GetAllColorResponse> getAllColorResponses =
                result.stream().map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllColorResponse>>(getAllColorResponses);
    }
}
