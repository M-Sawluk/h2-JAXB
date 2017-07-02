package com.michal;

import com.michal.domain.Address;
import com.michal.domain.User;
import com.michal.repository.AddressRepo;
import com.michal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class H2TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2TestApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private AddressRepo addressRepo;

	@PostConstruct
	public void saveUsers(){
		User user = new User();
		user.setName("Michal");

		Address address = new Address();
		address.setCity("Lublin");
		addressRepo.save(address);
		user.setAddress(new ArrayList<>(Arrays.asList(address)));
		address.setUsers(new ArrayList<>(Arrays.asList(user)));

		userRepository.save(user);
		addressRepo.save(address);

	}
}
