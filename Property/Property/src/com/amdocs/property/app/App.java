package com.amdocs.property.app;
import com.amdocs.property.dao.*;
import com.amdocs.property.exception.InvalidContactNoException;
import com.amdocs.property.exception.PropertyException;
import com.amdocs.property.model.Property;

import java.sql.SQLException;
import java.util.*;

public class App {
	public static void main(String[] args) throws Exception {
		PropertyDAO pDAO = new PropertyDAO();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int propertyId;
        String noOfRooms;
        double areaInSqft;
        int floorNo;
        String city;
        String state;
        double cost;
        double mincost;
        double maxcost;
        String ownerName;
        String ownerContactNo;
        System.out.println("Welcome to Property Search System");
        while(true) {
//        	PropertyDAO pDAO;
        	Property property;
        	
            System.out.println("1. Add new property");
            System.out.println("2. Update property cost");
            System.out.println("3. Delete property");
            System.out.println("4. Find by city");
            System.out.println("5. View all properties");
            System.out.println("6. Find by cost");
            System.out.println("7. Find by no. of rooms and city");
            System.out.println("8. Exit");
            System.out.println();
            System.out.println("Enter your choice:");
            
            int choice = sc.nextInt();
            switch(choice) {
            case 1:
            	System.out.println("To insert a record please enter the following");
            	System.out.println("Enter property ID: ");
            	propertyId = sc.nextInt();
            	System.out.println("Enter no of rooms: ");
                noOfRooms = sc.next();
                System.out.println("Enter the area in sqft: ");
                areaInSqft = sc.nextDouble();
                System.out.println("Enter the floor number: ");
                floorNo = sc.nextInt();
                System.out.println("Enter the city: ");
                city = sc.next().toLowerCase();
                System.out.println("Enter the state: ");
                state = sc.next().toLowerCase();
                System.out.println("Enter the cost: ");
                cost = sc.nextDouble();
                System.out.println("Enter Owner name: ");
                ownerName = sc.next().toLowerCase();
                do {
                System.out.println("Enter Owner number: ");
                ownerContactNo = sc.next();
                try {
					if(ownerContactNo.length()!=10) {
						throw new InvalidContactNoException("Please provide valid number");
					}
				} catch (InvalidContactNoException e) {
					System.out.println(e);
				}
                }while(ownerContactNo.length()!=10);
                
//            	pDAO = new PropertyDAO();
                property = new Property(propertyId,noOfRooms,areaInSqft,floorNo,city,state,cost,ownerName,ownerContactNo);
                System.out.println(property.toString());
                try {
        			int result = pDAO.addProperty(property);
        			if (result != -1){
        				System.out.println("Property Added successfully");
        			}
        			else {
						throw new PropertyException("Error in inserting record:(");
					}
        		} catch (PropertyException e) {
        			// TODO Auto-generated catch block
        			System.out.println(e);
        		}
                DBconnection.close();
            	break;
            	
            case 2:
            	System.out.println("Enter the property ID: ");
            	propertyId = sc.nextInt();
            	System.out.println("Enter the cost: ");
                cost = sc.nextDouble();
//                pDAO = new PropertyDAO();
                try {
        			boolean result = pDAO.updatePropertyCost(propertyId,cost);
        			if (result){
        				System.out.println("Property Updated successfully");
        			}
        			else {
        				throw new PropertyException("Issue in updating record.Please enter correct values");
        			}
        		} catch (PropertyException e) {
        			// TODO Auto-generated catch block
        			System.out.println(e);
        		}
                DBconnection.close();
            	break;
            case 3:
            	System.out.println("Enter the Property ID you want to delete: ");
            	propertyId = sc.nextInt();
//                pDAO = new PropertyDAO();
                try {
        			int result = pDAO.deleteProperty(propertyId);
        			if (result!=-1)
        			{
        				System.out.println("Property Deleted successfully");
        			}
        			else {
        				throw new PropertyException("Please mention correct ID. Property Not found");
        			}
        		} catch (PropertyException e) {
        			// TODO Auto-generated catch block
        			System.out.println(e);
        		}
                DBconnection.close();
                break;
            case 4:
            	System.out.println("Enter the city: ");
            	city = sc.next();
//            	pDAO = new PropertyDAO();
                try {
        			List<Property> result = pDAO.searchByCity(city);
        			if (!result.isEmpty()){
        				System.out.println("Property found successfully");
        				for (int i=0;i<result.size();i++){
        					System.out.println(result.get(i).toString());
        				}
        				
        			}
        			else {
        				throw new PropertyException("City not found!!");
        			}
        		} catch (PropertyException e) {
        			System.out.println(e);
        		}
                DBconnection.close();
               break;
            case 5:
                try {
        			List<Property> resut = pDAO.showAllProperties();
        			if (!resut.isEmpty()){
        				System.out.println("Properties found successfully");
        				for (int i=0;i<resut.size();i++){
        					System.out.println(resut.get(i).toString());
        				}
        			}
        			else {
						throw new PropertyException("No records found!!!");
					}
        		} catch (PropertyException e) {
        			System.out.println(e);
        		}
                DBconnection.close();
                break;
            case 6:
            	System.out.println("Enter the price range: ");
            	System.out.println("Enter the minimum cost: ");
            	mincost = sc.nextDouble();
            	System.out.println("Enter the maximum cost: ");
            	maxcost = sc.nextDouble();
                try {
        			List<Property> result = pDAO.searchByCost(mincost,maxcost);
        			if (!result.isEmpty()){
        				System.out.println("Property found successfully");
        				for (int i=0;i<result.size();i++)
        				{
        					System.out.println(result.get(i).toString());
        				}
        			}
        			else {
        				throw new PropertyException("Sorry! No records found in given range");
        			}
        		} catch (PropertyException e) {
        			System.out.println(e);
        		}
                DBconnection.close();
                break;
            case 7:
            	System.out.println("Enter the number of rooms: ");
            	noOfRooms = sc.next();
            	System.out.println("Enter the city name: ");
            	city = sc.next();
                try {
        			List<Property> result = pDAO.searchByNoOfRoomsAndCity(noOfRooms,city);
        			
        			if (!result.isEmpty()){
        				System.out.println("Property found successfully");
        				for (int i=0;i<result.size();i++){
        					System.out.println(result.get(i).toString());
        				}
        			}
        			else {
						throw new PropertyException("No property found with given specifications!!");
					}
        		} catch (PropertyException e) {
        			System.out.println(e);
        		}
                DBconnection.close();
                break;
            case 8:
                System.out.println("Thank you, Visit again:)");
            	System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");	
            }
//            sc.close();
            
        } 
        
	}
	
}
