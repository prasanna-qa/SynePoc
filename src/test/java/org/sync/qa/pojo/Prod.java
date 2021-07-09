package org.sync.qa.pojo;

import org.apache.juneau.annotation.Beanc;

public class Prod
{
	@Beanc(properties="username,password")
    public Prod(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
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
}