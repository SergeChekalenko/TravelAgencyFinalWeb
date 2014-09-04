package com.paranoia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.paranoia.dao.TourDAO;
import com.paranoia.entity.Tour;


@FacesConverter("com.paranoia.converter.TourConverter")
public class TourConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

			TourDAO tt;
			try {
				Context ctx = new InitialContext();
				tt = (TourDAO) ctx
						.lookup("java:global/TravelAgencyFinal/TravelAgencyFinalEJB/TourDAO");
				Tour type = tt.findTour(Integer.valueOf(arg2));
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

			if (arg2 instanceof Tour) {
				return ((Tour) arg2).getTourId() + "";
			}
			return null;
		}
	
}
