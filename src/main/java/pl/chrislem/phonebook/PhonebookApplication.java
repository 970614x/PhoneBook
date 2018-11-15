package pl.chrislem.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhonebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
//
//		SampleSingleton sampleSingleton = SampleSingleton.getInstance();
//		sampleSingleton.setName("Oskar");
//
//		SampleSingleton sampleSingleton1 = SampleSingleton.getInstance();
//		sampleSingleton1.setName("Wera");
//
//		SampleSingleton.getInstance().setName("Kacper");
//
//		System.out.println(sampleSingleton.getName());
	}
}
