package com.amdocs.property.dao;
import java.util.List;

import com.amdocs.property.exception.PropertyException;
import com.amdocs.property.model.Property;

public interface DAO {
	int addProperty(Property property) throws PropertyException;
	int deleteProperty(int propertyId) throws PropertyException;
	boolean updatePropertyCost(int propertyId,double cost) throws PropertyException;
	List<Property> searchByCity(String city) throws PropertyException;
	List<Property> showAllProperties() throws PropertyException;
	List<Property> searchByCost(double minCost,double maxCost) throws PropertyException;
	List<Property> searchByNoOfRoomsAndCity(String noOfRooms, String city) throws PropertyException;
}
