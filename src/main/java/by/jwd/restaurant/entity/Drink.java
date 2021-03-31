package by.jwd.restaurant.entity;

import java.io.Serializable;

public class Drink implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private boolean isAvailable;
    private String picturePath;

    public Drink() {
    }

    public Drink(Integer id, String title, String description, double price, boolean isAvailable, String picturePath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.picturePath = picturePath;
    }

    public Drink(Integer id, String title, String description, double price, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink)) return false;

        Drink drink = (Drink) o;

        if (Double.compare(drink.price, price) != 0) return false;
        if (isAvailable != drink.isAvailable) return false;
        if (!id.equals(drink.id)) return false;
        if (!title.equals(drink.title)) return false;
        if (!description.equals(drink.description)) return false;
        return picturePath.equals(drink.picturePath);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isAvailable ? 1 : 0);
        result = 31 * result + picturePath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
