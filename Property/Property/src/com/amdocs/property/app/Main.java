package com.amdocs.property.app;

import com.amdocs.property.model.Property;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
//		Property property = new Property(1, "4", 34d, 2, "Kadapa", "Andhra Pradesh",7500d, "Kishore", "1234567890");
//		System.out.println(property);
//		Scanner sc = new Scanner(System.in);
////      PropertyDAO propertyDAO = new PropertyDAO();
//		int choice = 0;
//		do {
//	          System.out.println("Enter your choice:");
//	          System.out.println("1. Add new property");
//	          System.out.println("2. Update property cost");
//	          System.out.println("3. Delete property");
//	          System.out.println("4. Find by city");
//	          System.out.println("5. View all properties");
//	          System.out.println("6. Find by cost");
//	          System.out.println("7. Find by no of rooms and city");
//	          System.out.println("8. Exit");
//
//	          choice = sc.nextInt();
//	          sc.nextLine(); // Consume newline
//
//          switch (choice) {
//              case 1:
//                  // Add new property
//                  System.out.print("Enter number of rooms: ");
//                  String noOfRooms = sc.nextLine();
//                  System.out.print("Enter area in sqft: ");
//                  double areaInSqft = sc.nextDouble();
//                  // Add other property details
//                  Property newProperty = new Property(0, noOfRooms, areaInSqft, 0, "", "", 0, "", "");
////                  int propertyId = propertyDAO.addProperty(newProperty);
//                  System.out.println("Property added with ID: " + propertyId);
//                  break;
//
//              case 2:
//                  // Update property cost
//                  System.out.print("Enter property ID: ");
//                  int propertyIdToUpdate = sc.nextInt();
//                  System.out.print("Enter new cost: ");
//                  double newCost = sc.nextDouble();
//                  boolean success = propertyDAO.updatePropertyCost(propertyIdToUpdate, newCost);
//                  if (success) {
//                      System.out.println("Property cost updated successfully.");
//                  } else {
//                      System.out.println("Property not found.");
//                  }
//                  break;
//
//              case 3:
//                  // Delete property
//                  System.out.print("Enter property ID to delete: ");
//                  int propertyIdToDelete = sc.nextInt();
//                  int deletedPropertyId = propertyDAO.deleteProperty(propertyIdToDelete);
//                  if (deletedPropertyId != -1) {
//                      System.out.println("Property with ID " + deletedPropertyId + " deleted successfully.");
//                  } else {
//                      System.out.println("Property not found.");
//                  }
//                  break;
//
//              case 4:
//                  // Find by city
//                  System.out.print("Enter city: ");
//                  String city = sc.nextLine();
//                  List<Property> propertiesByCity = propertyDAO.searchByCity(city);
//                  if (!propertiesByCity.isEmpty()) {
//                      System.out.println("Properties found:");
//                      for (Property property : propertiesByCity) {
//                          System.out.println(property);
//                      }
//                  } else {
//                      System.out.println("No properties found for the given city.");
//                  }
//                  break;
//
//              case 5:
//                  // View all properties
//                  List<Property> allProperties = propertyDAO.showAllProperties();
//                  if (!allProperties.isEmpty()) {
//                      System.out.println("All Properties:");
//                      for (Property property : allProperties) {
//                          System.out.println(property);
//                      }
//                  } else {
//                      System.out.println("No properties available.");
//                  }
//                  break;
//
//              case 6:
//                  // Find by cost range
//                  System.out.print("Enter min cost: ");
//                  double minCost = sc.nextDouble();
//                  System.out.print("Enter max cost: ");
//                  double maxCost = sc.nextDouble();
//                  List<Property> propertiesByCostRange = propertyDAO.searchByCost(minCost, maxCost);
//                  if (!propertiesByCostRange.isEmpty()) {
//                      System.out.println("Properties found:");
//                      for (Property property : propertiesByCostRange) {
//                          System.out.println(property);
//                      }
//                  } else {
//                      System.out.println("No properties found in the given cost range.");
//                  }
//                  break;
//
//              case 7:
//                  // Find by no of rooms and city
//                  System.out.print("Enter number of rooms (e.g., 1BHK or 2BHK): ");
//                  String rooms = sc.nextLine();
//                  System.out.print("Enter city: ");
//                  String searchCity = sc.nextLine();
//                  List<Property> propertiesByRoomsAndCity = propertyDAO.searchByNoOfRoomsAndCity(rooms, searchCity);
//                  if (!propertiesByRoomsAndCity.isEmpty()) {
//                      System.out.println("Properties found:");
//                      for (Property property : propertiesByRoomsAndCity) {
//                          System.out.println(property);
//                      }
//                  } else {
//                      System.out.println("No properties found for the given criteria.");
//                  }
//                  break;
//
//              case 8:
//                  System.out.println("Exiting...");
////                  System.exit(0);
//                  break;
//
//              default:
//                  System.out.println("Invalid choice. Please try again.");
//          }
//
//      } while (choice != 8);
//
//      sc.close();
//
//		
//
	}

}