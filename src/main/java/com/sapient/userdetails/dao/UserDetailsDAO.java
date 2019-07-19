package com.sapient.userdetails.dao;

import java.util.List;

import com.sapient.userdetails.model.Post;
import com.sapient.userdetails.model.User;

public interface UserDetailsDAO {
	public User save(User user);
	public User findbyid(int user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public void createPost(int post,Post post1);
	public List<Post> getPostByUid(int id);
	public List<Post> getPost();
	public void deletePostByUidAnsPid(int uid,int pid);
	public void deletePostByUid(int uid);

}
