package com.paranoia.beans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paranoia.dao.MyOrderDAO;

@ManagedBean
@SessionScoped
@Named
public class MyOrderDAOBeanCDI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject MyOrderDAO myorderdao;
	
	public void createMyOerder(){
//		myorderdao.createMyOrder();
	}
	
	public void deleteMyOrder(){}
	
	public void updateMyOrder(){}
}
