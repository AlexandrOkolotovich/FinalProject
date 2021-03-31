package by.jwd.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {
    private Integer id;
    private String name;
    private Integer menuDishesId;
    private Date creationDate;
    private String picturePath;

    public Menu() {
    }

    public Menu(Integer id, String name, Integer menuDishesId, Date creationDate, String picturePath) {
        this.id = id;
        this.name = name;
        this.menuDishesId = menuDishesId;
        this.creationDate = creationDate;
        this.picturePath = picturePath;
    }

    public Menu(Integer id, String name, Integer menuDishesId, Date creationDate) {
        this.id = id;
        this.name = name;
        this.menuDishesId = menuDishesId;
        this.creationDate = creationDate;
    }

    public Menu(Integer id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuDishesId() {
        return menuDishesId;
    }

    public void setMenuDishesId(Integer menuDishesId) {
        this.menuDishesId = menuDishesId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        if (!(o instanceof Menu)) return false;

        Menu menu = (Menu) o;

        if (!id.equals(menu.id)) return false;
        if (!name.equals(menu.name)) return false;
        if (!menuDishesId.equals(menu.menuDishesId)) return false;
        if (!creationDate.equals(menu.creationDate)) return false;
        return picturePath.equals(menu.picturePath);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + menuDishesId.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + picturePath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menuDishesId=" + menuDishesId +
                ", creationDate=" + creationDate +
                '}';
    }
}
