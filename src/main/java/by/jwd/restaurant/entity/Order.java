package by.jwd.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;
    private String status;
    private Date time;
    private Integer orderPaymentMethodId;
    private double totalPrice;
    private String review;
    private Integer userId;
    private Integer tableReservationId;

    public Order() {
    }

    public Order(Integer id, String status, Date time, Integer orderPaymentMethodId, double totalPrice, String review, Integer userId, Integer tableReservationId) {
        this.id = id;
        this.status = status;
        this.time = time;
        this.orderPaymentMethodId = orderPaymentMethodId;
        this.totalPrice = totalPrice;
        this.review = review;
        this.userId = userId;
        this.tableReservationId = tableReservationId;
    }

    public Order(Integer id, String status, Date time, double totalPrice, String review) {
        this.id = id;
        this.status = status;
        this.time = time;
        this.totalPrice = totalPrice;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getOrderPaymentMethodId() {
        return orderPaymentMethodId;
    }

    public void setOrderPaymentMethodId(Integer orderPaymentMethodId) {
        this.orderPaymentMethodId = orderPaymentMethodId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTableReservationId() {
        return tableReservationId;
    }

    public void setTableReservationId(Integer tableReservationId) {
        this.tableReservationId = tableReservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (Double.compare(order.totalPrice, totalPrice) != 0) return false;
        if (!id.equals(order.id)) return false;
        if (!status.equals(order.status)) return false;
        if (!time.equals(order.time)) return false;
        if (!orderPaymentMethodId.equals(order.orderPaymentMethodId)) return false;
        if (!review.equals(order.review)) return false;
        if (!userId.equals(order.userId)) return false;
        return tableReservationId.equals(order.tableReservationId);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + orderPaymentMethodId.hashCode();
        temp = Double.doubleToLongBits(totalPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + review.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + tableReservationId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", time=" + time +
                ", orderPaymentMethodId=" + orderPaymentMethodId +
                ", totalPrice=" + totalPrice +
                ", review='" + review + '\'' +
                ", userId=" + userId +
                ", tableReservationId=" + tableReservationId +
                '}';
    }
}
