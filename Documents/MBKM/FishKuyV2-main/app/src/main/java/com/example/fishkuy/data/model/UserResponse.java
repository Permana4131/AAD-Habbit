package com.example.fishkuy.data.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	public int getSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}

	public User getUser(){
		return user;
	}
}