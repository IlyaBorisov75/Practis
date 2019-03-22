package SpringOnPractis.Practis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.collect.ImmutableList;

import SpringOnPractis.Practis.web.PeopleController;
import SpringOnPractis.Practis.service.*;
import model.people;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GetListOfPeopleTest {
	@Mock
	private PeopleService PeopleService;
	@InjectMocks
	PeopleController sut;
	
	
	@Test
	public void testGetListOfPeople() throws Exception{
		//prepare
		when(PeopleService.findAll()).thenReturn(ImmutableList.of());
		//testing
		List<people> ListOfPeople= sut.GetListOfPeople();
		//fail("Not yet implemented");
		verify(PeopleService).findAll();
	}

}
