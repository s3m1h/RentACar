package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
	private int id;
	private double dailyPrice;
	private boolean state;
	private String colorName;
	private String modelName;
	private String brandName;
	private int modelYear;

}
