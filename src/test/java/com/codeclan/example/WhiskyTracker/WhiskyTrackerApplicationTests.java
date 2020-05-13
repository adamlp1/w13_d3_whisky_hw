package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	private WhiskyRepository whiskyRepository;

	@Autowired
	private DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateAndSaveWhiskyThatHasADistillery(){

		Distillery distillery = new Distillery("Glenfiddich", "Campbelltown");
		distilleryRepository.save(distillery);

		Whisky whisky = new Whisky("The Famous Grouse", 25, 2017, distillery);
		whiskyRepository.save(whisky);
	}

	@Test
	public void canFindWhiskiesByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAge(18);
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Speyside");
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge("Macallan", 25);
	}

}
