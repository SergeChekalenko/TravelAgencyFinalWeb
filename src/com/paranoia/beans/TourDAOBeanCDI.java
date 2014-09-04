package com.paranoia.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paranoia.dao.TourDAO;
import com.paranoia.entity.Tour;
import com.paranoia.entity.TourType;

@ManagedBean
@SessionScoped
@Named
public class TourDAOBeanCDI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject TourDAO tourdao;
	
	private TourType tourTypeTourDAOBean;
	private int price;
	private Tour selectedTour;
	
	public void createTour(){
		
		
		tourdao.createTour(tourTypeTourDAOBean, price);
	}
	
	public void deleteTour(){}
	
	public void updateTour(){}

	public List<Tour> getListValuesTour() {
		return tourdao.getAllTours();
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public TourType getTourTypeTourDAOBean() {
		return tourTypeTourDAOBean;
	}

	public void setTourTypeTourDAOBean(TourType tourTypeTourDAOBean) {
		this.tourTypeTourDAOBean = tourTypeTourDAOBean;
	}

	public Tour getSelectedTour() {
		return selectedTour;
	}

	public void setSelectedTour(Tour selectedTour) {
		this.selectedTour = selectedTour;
	}

}
