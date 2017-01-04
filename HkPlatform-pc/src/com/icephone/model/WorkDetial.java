package com.icephone.model;

import java.util.ArrayList;

import com.icephone.pojo.Comments;
import com.icephone.pojo.Users;

public class WorkDetial {

	private Users user;
	private ArrayList<Comments> comments;
	
	public WorkDetial() {
		super();
	}
	
	public WorkDetial(Users user, ArrayList<Comments> comments) {
		super();
		this.user = user;
		this.comments = comments;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ArrayList<Comments> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comments> comments) {
		this.comments = comments;
	}
	
	
}
