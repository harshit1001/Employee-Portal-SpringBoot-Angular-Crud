package controllers;

import br.com.crud.demo.service.ProductService;
import interfaces.GenericOperations;
import models.Product;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@PostMapping()
	public ResponseEntity<Product> post(@RequestBody Product entity) {
		int res = productService.put(entity);
		if (res == 1)
			return new ResponseEntity<>(entity, HttpStatus.OK);
		else
			return new ResponseEntity<>(entity, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
      String message = "";
 List<Product> tutorials = new ArrayList<Product>();
     	   try {
   			   BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
   		        CSVParser csvParser = new CSVParser(fileReader,
   		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()); 

   		     

   		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

   		      for (CSVRecord csvRecord : csvRecords) {
   		    	String a=csvRecord.get("User Id");
   		        Product tutorial = new Product(
   		              Integer.parseInt(a),
   		              csvRecord.get("code"),
   		              csvRecord.get("name"),
   		           csvRecord.get("description"),
   		              Integer.parseInt(csvRecord.get("Salary"))
   		            );

   		        tutorials.add(tutorial);
   		      }

   		  
   		    } catch (IOException e) {
   		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
   		    }
//   		message="Uploaded the file successfully: "+file.getOriginalFilename();return ResponseEntity.status(HttpStatus.OK).body(message);
//   		message="Please upload a csv file!";
   		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//productService.saveAll(tutorials);
   		   this.productService.saveAll(tutorials);
   		   return ResponseEntity.ok("dfd");
   		    

	
	
}

	
	@GetMapping("/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Product> listUsers = productService.get();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "User ID", "code", "description", "name", "Salary" };
		String[] nameMapping = { "id", "code", "description", "name", "value" };

		csvWriter.writeHeader(csvHeader);

		for (Product user : listUsers) {
			csvWriter.write(user, nameMapping);
		}

		csvWriter.close();
	}

	@PostMapping(value = "/edit/")
	public ResponseEntity<Product> edit(@RequestBody Product entity) {
		int res = productService.edit(entity);
		if (res == 1)
			return new ResponseEntity<>(entity, HttpStatus.OK);
		else
			return new ResponseEntity<>(entity, HttpStatus.BAD_REQUEST);

	}

	@GetMapping()
	public List<Product> get() {
		return productService.get();
	}

	@GetMapping("/t")

	public ResponseEntity<List<Product>> t() {
		return ResponseEntity.ok(productService.get());
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Integer> delete(@PathVariable int id) {

		int res = productService.delete(id);
		if (res == 1)
			return new ResponseEntity<>(id, HttpStatus.OK);
		else
			return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/test/{id}")
	public int a(@PathVariable int id) {
		return id;
	}
}
