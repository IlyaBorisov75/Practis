package SpringOnPractis.Practis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.people;
import SpringOnPractis.Practis.service.PeopleService;


@RestController
@RequestMapping("/api/people")
public class PeopleController {
	@Autowired
	private PeopleService PeopleService;
	
	@RequestMapping
	public List<people> GetListOfPeople(){
		return PeopleService.findAll();
	}
}
