package com.sapient.userdetails.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.userdetails.model.Post;
import com.sapient.userdetails.model.User;
import com.sapient.userdetails.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@RestController
@RequestMapping("/api/v1/products") //v1 for version change 
public class UserController {

	@Autowired 
	private UserService userservice;
//	public UserController(UserService userservice) {
//		this.userservice = userservice;
//	}
	
	@GetMapping(value = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public List<Post> getPost(){
		/*
		List<Product> products = Arrays.asList(new Product(), new Product(), new Product());
		return products;
		*/
		System.out.println("hiii");
		
		List<Post> e1 = this.userservice.getPost();
	       for(Post e : e1 ) {
	     	System.out.println(e);
	     }    
	       
	     return e1;
    
	}
	
	
	@GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public List<Post> getPostByUid(@PathVariable int id){
		System.out.println("hiii");
		
		List<Post> e1 = this.userservice.getPostByUid(id);
	       for(Post e : e1 ) {
	     	System.out.println(e);
	     }    
	       
	     return e1;
    
	}
	
	
	@PostMapping(value= "/", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void saveUser(@Valid @RequestBody User user) {
		System.out.println("came in save pro");
		userservice.saveUser(user);
	}
	
	
	
	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable int id) {
		System.out.println("came in delete pro");
		userservice.deleteUser(id);
	}
	
	@PostMapping(value= "/{id}", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void createPost(@Valid @RequestBody Post user,@PathVariable int id) {
		System.out.println("came in save pro");
		userservice.createPost(id,user);
	}
	
	@DeleteMapping(value = "/pp/{id}")
	public void deletePostByUidAnsPid(@Valid @RequestBody int uid,@PathVariable int id) {
		System.out.println("6666666666666666666666666666");
		userservice.deletePostByUidAnsPid(uid,id);
	}
	
	@DeleteMapping(value = "/ppp/{id}")
	public void deletePostByUid(@PathVariable int id) {
		System.out.println("6666666666666666666666666666");
		userservice.deletePostByUid(id);
	}
	
	@PutMapping(value= "/{id}",consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void updateUser(@PathVariable int id,@Valid @RequestBody User user) {
		System.out.println(user.getId());
		user.setId(id);
		userservice.updateUser(user);
	}
	
}
