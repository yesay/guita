package cn.suius.guita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GuitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitaApplication.class, args);
	}

	@RequestMapping("/")
	public String hello(){
		return  "hello spring security!";
	}

	@RequestMapping("/hello")
	public String goQingdao(){
		return "by car";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/filterRole")
	public String filterRole(){
		return "admining";
	}

	@PreAuthorize("#id<10 and principal.username.equals(#username) and #user.username.equals('')")
	@PostAuthorize("returnObject%2==0")
	@PreFilter("")
	@PostFilter("")
	public Integer test(Integer id, String username, User user){
		return id;
	}

	@PreFilter("filterObject%2==0")
	@PostFilter("filterObject%4==0")
	@RequestMapping("/test2")
	public List<Integer> test2(List<Integer> idList){
		return idList;
	}
}
