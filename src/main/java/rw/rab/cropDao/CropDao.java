/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rw.rab.cropDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rw.rab.model.Crop;

/**
 *
 * @author nsumba
 */
public class CropDao {
    //JDBC Properties
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/crop_management_java";
    private String dbUsername = "postgres";
    private String dbPassword = "1234";
    
    //CREATE OPERATION
    public Integer registerCrop(Crop cropObj){
        //step 0: surround everything with try and catch
        try{
            //step1: create a connection
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            //step 2: create statement
            String sql = "INSERT INTO crops (name, id, lifespan, price) VALUES(?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, cropObj.getName());
            pst.setInt(2, cropObj.getId());
            pst.setInt(3, cropObj.getLifespan());
            pst.setInt(4, cropObj.getPrice());
            
            //step3: executing the data into the database
            int rowsAffected = pst.executeUpdate();
            
            //step4: close connection
            con.close();
            return rowsAffected;
            
        }catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
    
    //UPDATE OPERATION
    public Integer updateCrop(Crop cropObj){
        //step0: surround anything with try and catch
        try{
            //step1: create a connection
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            String sql = "UPDATE crops SET name = ?, lifespan = ?, price = ? WHERE id = ?";
            //step2: preparedStatement
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setString(1, cropObj.getName());
            pst.setInt(3, cropObj.getLifespan());
            pst.setInt(3, cropObj.getPrice());
            pst.setInt(4, cropObj.getId());
            
                       
            //step3: execute statement
            int rowsAffected = pst.executeUpdate();
            
            
            //step4: close connection
            con.close();
            return rowsAffected;
            
        
        }catch(Exception ex){
            ex.printStackTrace();
            return 0;
    }
        
    
       }
    //DELETE OPERATION
    public Integer deleteCrop(int id) {
        try {
            // step1: create connection
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // step2: prepare statement
            String sql = "DELETE FROM crops WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            // step3: execute statement
            int rowsAffected = pst.executeUpdate();

            // step4: close connection
            con.close();

            return rowsAffected;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    //READ ALL
    // READ ALL OPERATION
    public List<Crop> findAllCrops() {
        List<Crop> cropList = new ArrayList<>();

        try {
            // step1: create connection
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // step2: prepare statement
            String sql = "SELECT * FROM crops";
            PreparedStatement pst = con.prepareStatement(sql);

            // step3: execute query
            ResultSet rs = pst.executeQuery();

            // step4: loop through result set
            while (rs.next()) {
                Crop cropObj = new Crop();

                cropObj.setName(rs.getString("name"));
                cropObj.setId(rs.getInt("id"));
                cropObj.setLifespan(rs.getInt("lifespan"));
                cropObj.setPrice(rs.getInt("price"));

                cropList.add(cropObj);
            }

            // step5: close connection
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cropList;
    }
    
 }
