package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concrete.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

	Model getByName(String modelName);
	Model getByNameAndBrand_Id(String modelName, int brandId);
	List<Model> getByNameOrBrand_Id(String modelName, int brandId);
	List<Model> getByBrandIn(List<Integer> brands);
	List<Model> getByNameContains(String modelName);
	List<Model> getByNameStartsWith(String modelName);
	
}
