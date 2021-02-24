package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository  {

    List<Product> findProductsByName(Integer id){
    	return new ArrayList<Product>(Arrays.asList(new Product()) );
    }

}
