package com.paranoia.beans;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paranoia.dao.TourTypeDAO;
import com.paranoia.entity.TourType;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
@Named
public class TourTypeDAOBeanCDI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	TourTypeDAO ttdao;

	private String name;
	private TourType selectedValue;

	// ////////////////////add new tourtype
	public void createNewTourType() {

		if (name != null) {
			ttdao.createNewTourType(name);
		}
	}

	public void deleteTourType() {
		ttdao.deleteTourType(selectedValue);
	}

	public void updateTourType() {
		ttdao.updateTourType(selectedValue);
	}

	// /////////////converter thing
	public List<TourType> getListValues() {
		return ttdao.getAllTourTypes();
	}

	public void systemout() {
		System.out.println(selectedValue.getTourName());
	}

	// /////getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TourType getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(TourType selectedValue) {
		this.selectedValue = selectedValue;
	}

}
