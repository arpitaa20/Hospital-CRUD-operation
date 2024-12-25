package jsp.SpringBoot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsp")
public class HospitalController {
	
	@Autowired
	private HospitalRepository hr;
	
//	Insert all the info
	@PostMapping("/hospital")
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital h){
		hr.save(h);
		ResponseStructure<Hospital> str= new ResponseStructure<Hospital>();
		str.setStatusCode(HttpStatus.CREATED.value());
		str.setMessage("Success");
		str.setData(h);
		return str;
	}
	
//	get all the info
	@GetMapping("/hospital")
	public ResponseStructure<List<Hospital>> getAllHospitals(){
		List<Hospital> h = hr.findAll();
		ResponseStructure<List<Hospital>> str= new ResponseStructure<List<Hospital>>();
		str.setStatusCode(HttpStatus.OK.value());
		str.setMessage("Success");
		str.setData(h);
		return str;
	}
	
//	get info by the particular id
	@GetMapping("/hospital/{id}")
	public Hospital getHospitalById(@PathVariable int id) {
		Optional<Hospital> opt = hr.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
			
		}else {
			return null;
		}
 	}
	
//	update the info
	@PutMapping("/hospital")
	public String updateHospital(@RequestBody Hospital h) {
		hr.save(h);
		return "Hospital record updated";
	}
	
//	delete the info by id
	@DeleteMapping("/hospital/{id}")
	public String deleteHospitalById(@PathVariable int id) {
		Optional<Hospital> opt = hr.findById(id);
		if(opt.isPresent()) {
			hr.delete(opt.get());
			return "Hospital record is delete";
		}else {
			return "No record delete";
		}
		
	}

}
