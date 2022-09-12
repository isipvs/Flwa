package entity;

import java.math.BigDecimal;

/** */
public class Product {
    int id;
    String name, shortName, note, imageId;
    BigDecimal price;

    /** */
    public Product() {}

    /** */
    public Product(int id, String name, String shortName, String note, BigDecimal price, String imageId) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.note = note;
        this.imageId = imageId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
