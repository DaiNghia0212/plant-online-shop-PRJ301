/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.product;

/**
 *
 * @author daing
 */
public class Product {
    private int producId;
    private String name;
    private int price;
    private String imgpath;
    private String description;
    private int status;
    private int cateid;
    private String catename;



    public int getId() {
        return producId;
    }

    public void setId(int id) {
        this.producId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    @Override
    public String toString() {
        return "Plant{" + "id=" + producId + ", name=" + name + ", price=" + price + ", imgpath=" + imgpath + ", description=" + description + ", status=" + status + ", cateid=" + cateid + ", catename=" + catename + '}';
    }
}
