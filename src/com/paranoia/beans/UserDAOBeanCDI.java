package com.paranoia.beans;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paranoia.dao.UserDAO;
import com.paranoia.entity.Users;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
@Named
public class UserDAOBeanCDI implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject UserDAO userdao;
	
	private String userName;
	private String userPassword;
	private String userAdress;
	private String userType;
	private int userDiscount;
	
	private Users selectedUser;
	
	public void createUser(){
		if(userName!=null && userPassword!=null && userAdress!=null && userType!=null)
		userdao.createUser(userName, userPassword, userAdress, userType, userDiscount);
		
	}
	
	
	public void deleteUser(){
		System.out.println("ok");
		userdao.deleteUser(selectedUser);
	}
	
	public void updateUser(){}
	
	public List<Users> getListValuesUsers() {
		return userdao.getAllUsers();
	}
	
////////////////////getter and setter	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserDiscont() {
		return userDiscount;
	}

	public void setUserDiscont(int userDiscont) {
		this.userDiscount = userDiscont;
	}


	public Users getSelectedUser() {
		return selectedUser;
	}


	public void setSelectedUser(Users selectedUser) {
		this.selectedUser = selectedUser;
	}
}
