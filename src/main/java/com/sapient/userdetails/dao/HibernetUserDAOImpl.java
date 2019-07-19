package com.sapient.userdetails.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sapient.userdetails.model.Post;
import com.sapient.userdetails.model.User;

@Repository("hibernateDAOImpl")
public class HibernetUserDAOImpl implements UserDetailsDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public User save(User user) {
		System.out.println(user);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }
	public User findbyid(int id) {
		Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        return user;
    }
	
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        System.out.println(user.getId());
        User u=session.byId(User.class).load(user.getId());
        u.setName(user.getName());
        session.update(u);
	}
	
	public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
    }

	public void createPost(int id,Post post) {
        Session session = sessionFactory.getCurrentSession();
        User user=findbyid(id);
        List<Post> posts = user.getPost();
        posts.add(post);
        user.setPost(posts);
        session.saveOrUpdate(user);
    }

	public List<Post> getPostByUid(int id) {
		// TODO Auto-generated method stub
		 Session currentSession = sessionFactory.getCurrentSession();
	        return currentSession.createQuery("from Post where uid= " + id).list();
	}
	
	public List<Post> getPost() {
		// TODO Auto-generated method stub
		 Session currentSession = sessionFactory.getCurrentSession();
		 System.out.println(currentSession.createQuery("from post ").list());
	        return currentSession.createQuery("from post ").list();
	}
	
	public void deletePostByUidAnsPid(int uid,int pid) {
		// TODO Auto-generated method stub
		System.out.println("9999999999");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("7777777");
//        User employee = session.byId(User.class).load(uid);
		User employee = session.byId(User.class).load(pid);
		System.out.println("7777777 "+pid +"   "+ uid);

        List<Post> p1=employee.getPost();
        System.out.println(p1);
        for(Post p : p1) {
    		System.out.println("*****");

        	if(p.getId() == pid) {
        	p1.remove(p);
        	Post pd = session.byId(Post.class).load(pid);
        	session.delete(pd);
        	break;
        	}
        }
	}
	
	public void deletePostByUid(int uid) {
		System.out.println("!!!!!!!!!");
		Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(uid);
        user.setPost(null);
        //session.delete(employee);
	}
	
}
