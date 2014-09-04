package com.paranoia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.paranoia.dao.TourTypeDAO;
import com.paranoia.entity.TourType;

@FacesConverter("com.paranoia.converter.StringConverter")
public class StringConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		TourTypeDAO tt;
		try {
			Context ctx = new InitialContext();
			tt = (TourTypeDAO) ctx
					.lookup("java:global/TravelAgencyFinal/TravelAgencyFinalEJB/TourTypeDAO");
			TourType type = tt.findTourType(Integer.valueOf(arg2));
			System.out.println(type);
			return type;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 instanceof TourType) {
			return ((TourType) arg2).getTourTypeId() + "";
		}
		return null;
	}

}

