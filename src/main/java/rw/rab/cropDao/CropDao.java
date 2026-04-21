/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rw.rab.cropDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
    
}
