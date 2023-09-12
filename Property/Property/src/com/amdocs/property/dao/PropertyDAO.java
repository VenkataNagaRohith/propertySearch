package com.amdocs.property.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.amdocs.property.exception.PropertyException;
import com.amdocs.property.model.Property;

public class PropertyDAO implements DAO{
	public static String insert = "INSERT INTO records (propertyId, no_Of_Rooms, areaInSqft, "
			+ "floorNo, city, state_Name, costt, ownerName, ownerContactNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static String delete = "DELETE FROM records WHERE propertyId = ?";
	public static String searchByCity = "Select * from records where city = ? ";
	public static String showAllProperties = "SELECT * FROM records";
	public static String searchByCost = "select * from records where costt between ? and ?";
	public static String searchByRoomsAndCity = "select * from records where no_Of_Rooms = ? and city =?";
	@Override
	public int addProperty(Property property) throws PropertyException {
		Connection con = null;
		try {
			con = DBconnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		String sql = "INSERT INTO records (propertyId, no_Of_Rooms, areaInSqft, "
//				+ "floorNo, city, state_Name, costt, ownerName, ownerContactNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
        	statement.setInt(1, property.getPropertyId());
        	statement.setString(2, property.getNoOfRooms());
            statement.setDouble(3, property.getAreaInSqft());
            statement.setInt(4, property.getFloorNo());
            statement.setString(5, property.getCity());
            statement.setString(6, property.getState());
            statement.setDouble(7, property.getCost());
            statement.setString(8, property.getOwnerName());
            statement.setString(9, property.getOwnerContactNo());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                return 1;
            }else {
				return -1;
			}
         
//            DBconnection.close();
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
		
	}

	@Override
	public int deleteProperty(int propertyId) throws PropertyException{
//		String sql = "DELETE FROM records WHERE propertyId = ?";
        try{
        	Connection con = DBconnection.getConnection();
    		PreparedStatement ps = con.prepareStatement(delete);
    		ps.setInt(1, propertyId);
//    		
            int affectedRows = ps.executeUpdate();
            if(affectedRows>0) {
//            	con.close();
            	return 1;
            }
            else {
            	
            	return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
	}

	@Override
	public boolean updatePropertyCost(int propertyId,double newCost) throws PropertyException{
		String sql = "UPDATE records SET costt = "+newCost+" WHERE propertyId = "+propertyId;
		
        try{
        	Connection con = DBconnection.getConnection();
//        	PreparedStatement statement = con.prepareStatement(sql);
        	Statement statement = con.createStatement();
//            statement.setDouble(1, newCost);
//            statement.setInt(2, propertyId);
            int affectedRows = statement.executeUpdate(sql);
//            con.close();
            return affectedRows > 0;
        } catch (SQLException e){
            e.printStackTrace();
            // Handle the exception appropriately
            return false;
        }
	}

	@Override
	public List<Property> searchByCity(String city) throws PropertyException {
		List<Property> property = new ArrayList<>();
//		String query = "Select * from records where city = ? ";
		Connection con;
		try {
			con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(searchByCity);
			ps.setString(1, city);
//			Statement statement = con.createStatement();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Property prp = new Property(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getString(8),rs.getString(9));
				property.add(prp);
			}
//			DBconnection.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return property;
	}

	@Override
	public List<Property> showAllProperties() throws PropertyException {
		
//		String sql = "SELECT * FROM records";
		List<Property> property= new ArrayList<>();
		try {
			Connection con = DBconnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showAllProperties);

			while (rs.next()) {
//				int pId = rs.getInt(1);
//				String nr=rs.getString(2);
//				int ar=rs.getInt(3);
//				int fn=rs.getInt(4);
//				String st=rs.getString(5);
//				int cst=rs.getInt(6);
//				String ownName= rs.getString(7);
//				String ownNum=rs.getString(8);
				Property prp = new Property(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getString(8),rs.getString(9));
				property.add(prp);
			}
//			DBconnection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
	}

	@Override
	public List<Property> searchByCost(double minCost,double maxCost) throws PropertyException {
		List<Property> property = new ArrayList<>();
		try {
			Connection con = DBconnection.getConnection();
//			String query = "select * from records where costt between ? and ?";
			PreparedStatement ps = con.prepareStatement(searchByCost);
			ps.setDouble(1, minCost);
			ps.setDouble(2, maxCost);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Property prp = new Property(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getString(8),rs.getString(9));
				property.add(prp);
			}
//			DBconnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
	}

	@Override
	public List<Property> searchByNoOfRoomsAndCity(String noOfRooms, String city) throws PropertyException {
		List<Property> property = new ArrayList<>();
//		DBconnection con = null;
//		String query= "select * from records where no_Of_Rooms = ? and city =?";
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(searchByRoomsAndCity);
			ps.setString(1, noOfRooms);
			ps.setString(2, city);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Property prp = new Property(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDouble(7), rs.getString(8),rs.getString(9));
				property.add(prp);
				
			}
//			DBconnection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return property;
	}
	

}
