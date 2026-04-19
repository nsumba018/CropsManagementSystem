/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rw.rab.model;

/**
 *
 * @author nsumba
 */
public class Crop {
    //initializing the data members
    private String name;
    private Integer id;
    private Integer lifespan;
    private Integer price;

    public Crop() {
    }
    
    public Crop(String name, Integer id, Integer lifespan, Integer price){
        this.name = name;
        this.id = id;
        this.lifespan = lifespan;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    
    
    
}
