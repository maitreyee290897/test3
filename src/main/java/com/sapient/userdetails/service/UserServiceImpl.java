package com.sapient.userdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.userdetails.dao.UserDetailsDAO;
import com.sapient.userdetails.model.Post;
import com.sapient.userdetails.model.User;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	@Autowired()
	@Qualifier(value= "hibernateDAOImpl")
	 private UserDetailsDAO userDetailsDAO;
	
	public UserServiceImpl(@Qualifier(value= "hibernateDAOImpl") UserDetailsDAO userDAO){
		System.out.println("hiii0");
        this.userDetailsDAO = userDAO;
    }
	
	@Transactional
    public User saveUser(User user) {
        System.out.println("Inside the save employee method of Employee service class ....");
        return this.userDetailsDAO.save(user);
    }
	
	@Transactional
    public void updateUser(User user) {
		userDetailsDAO.updateUser(user);
    }
	
	@Transactional
    public void deleteUser(int id) {
		userDetailsDAO.deleteUser(id);
    }
	
	@Transactional
    public void createPost(int id,Post post) {
		userDetailsDAO.createPost(id,post);
    }
	
	@Transactional
    public List<Post> getPostByUid(int id) {
		return userDetailsDAO.getPostByUid(id);
    }
	
	@Transactional
    public List<Post> getPost() {
		return userDetailsDAO.getPost();
    }

	
	@Transactional
    public void deletePostByUidAnsPid(int uid,int pid) {
		userDetailsDAO.deletePostByUidAnsPid(uid,pid);
    }
	
	@Transactional
    public void deletePostByUid(int uid) {
		userDetailsDAO.deletePostByUid(uid);
    }

}
