package org.sync.qa.pojo;

import org.apache.juneau.annotation.Beanc;

public class It
{
    private String username;

    private String password;

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    
    @Beanc(properties="username,password")
	public It(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
