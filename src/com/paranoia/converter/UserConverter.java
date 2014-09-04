package com.paranoia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.paranoia.dao.UserDAO;
import com.paranoia.entity.Users;

@FacesConverter("com.paranoia.converter.UserConverter")
public class UserConverter implements Converter{


			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

				UserDAO tt;
				try {
					Context ctx = new InitialContext();
					tt = (UserDAO) ctx
							.lookup("java:global/TravelAgencyFinal/TravelAgencyFinalEJB/UserDAO");
					Users type = tt.findUser(Integer.valueOf(arg2));
					System.out.println(type.getUserName());
					return type;
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return null;

			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

				if (arg2 instanceof Users) {
					return ((Users) arg2).getUserId() + "";
				}
				return null;
			}
	
}
