package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.concrete.ColorManager;
import kodlama.io.rentACar.business.responses.GetAllColorResponse;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorsController {

    private final ColorService colorService;
    @GetMapping
    public DataResult<List<GetAllColorResponse>> getAll(){
        var result = colorService.getAll();
        if(result.isSuccess()){
            return result;
        }
        return null;
    }

}
