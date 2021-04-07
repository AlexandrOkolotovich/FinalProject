package by.jwd.restaurant.entity;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    READY,
    VIOLATED,
    PREPARING,
    CANCELED,
    EXPECTED,
    PAID
}
