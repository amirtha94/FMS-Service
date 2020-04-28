package com.fms.fmsevent.Service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.fmsevent.model.Role;
import com.fms.fmsevent.model.User;

import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	// this is just an example, you can load the user from the database from the repositor
	//username:passwowrd -> user:user
	/*
	 * private final String userUsername = "pmo";// password: user private final
	 * User user = new User("1",userUsername,
	 * "S3ReJy0odJ/k1Kh7JYY/cPplbH+Gls/Y5BbO5fwGDE0=", true,
	 * Arrays.asList(Role.ROLE_PMO));
	 * 
	 * //username:passwowrd -> admin:admin private final String adminUsername =
	 * "admin";// password: admin private final User admin = new
	 * User("2",adminUsername, "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true,
	 * Arrays.asList(Role.ROLE_ADMIN));
	 */
	public Mono<User> findByUsername(String username) {
		
		//Mono<UserInfo> userData = Mono.just(userInfo);
		Mono<User> userData = WebClient.builder().build().get().uri("http://localhost:8081/user/userInfo/{username}",username)
		.retrieve()
		.bodyToMono(User.class).log("get UserInfo data");
		System.out.println("userData-->"+userData);
		userData = userData.flatMap(i -> {System.out.println("iiii===>"+i);
			i.setRoles(Arrays.asList(Role.getEnumNameForValue(i.getRole())));
			System.out.println("iiii===>"+i);
			return Mono.just(i);
		});
		//userData.map(i-> i.setRoles(Arrays.asList(Role.getEnumNameForValue(i.getRole())));
		System.out.println(userData.map(i -> Arrays.asList(Role.getEnumNameForValue(i.getRole()))));
		return userData;
		/*
		 * if (username.equals(userUsername)) { return Mono.just(user); } else if
		 * (username.equals(adminUsername)) { return Mono.just(admin); } else { return
		 * Mono.empty(); }
		 */
	}
	
	
}