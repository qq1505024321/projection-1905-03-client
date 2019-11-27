package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private static final long serialVersionUID = -6904141555963347676L;
    private Integer carId;

    private String carName;

    private Date sellingDate;

    private Integer typeId;

    private Double carPrice;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", sellingDate=" + sellingDate +
                ", typeId=" + typeId +
                ", carPrice=" + carPrice +
                '}';
    }
}