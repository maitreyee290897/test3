package com.sapient.userdetails.service;

import java.util.List;

import com.sapient.userdetails.model.Post;
import com.sapient.userdetails.model.User;

public interface UserService {
	public User saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	public void createPost(int id,Post post);
	
	public List<Post> getPostByUid(int id);
	public List<Post> getPost();
	public void deletePostByUidAnsPid(int uid,int pid);
	public void deletePostByUid(int uid);

}
