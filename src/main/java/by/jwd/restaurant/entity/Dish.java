package by.jwd.restaurant.entity;

import java.io.Serializable;

public class Dish implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private float calorieContent;
    private boolean isAvailable;
    private String picturePath;

    public Dish() {
    }

    public Dish(Integer id, String title, String description, double price, float calorieContent, boolean isAvailable, String picturePath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.calorieContent = calorieContent;
        this.isAvailable = isAvailable;
        this.picturePath = picturePath;
    }

    public Dish(Integer id, String title, String description, double price, float calorieContent, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.calorieContent = calorieContent;
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

    public float getCalorieContent() {
        return calorieContent;
    }

    public void setCalorieContent(float calorieContent) {
        this.calorieContent = calorieContent;
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
        if (!(o instanceof Dish)) return false;

        Dish dish = (Dish) o;

        if (Double.compare(dish.price, price) != 0) return false;
        if (Float.compare(dish.calorieContent, calorieContent) != 0) return false;
        if (isAvailable != dish.isAvailable) return false;
        if (!id.equals(dish.id)) return false;
        if (!title.equals(dish.title)) return false;
        if (!description.equals(dish.description)) return false;
        return picturePath.equals(dish.picturePath);
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
        result = 31 * result + (calorieContent != +0.0f ? Float.floatToIntBits(calorieContent) : 0);
        result = 31 * result + (isAvailable ? 1 : 0);
        result = 31 * result + picturePath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", calorieContent=" + calorieContent +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
