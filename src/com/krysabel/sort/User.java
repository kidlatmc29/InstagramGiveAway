package com.krysabel.sort;

public class User {
	private String mName;
	private int mNumOfEntries; 
	
	public User(String name, int numOfEntries) {
		mName = name;
		mNumOfEntries = numOfEntries; 
	}
	
	public String getName() {
		return mName; 
	}
	
	public int getNumOfEntries() {
		return mNumOfEntries;
	}
	
}
