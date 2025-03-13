package com.checkout_service.entity;
import java.util.List;

public class Checkout {

    private String id;
    private String url;
    private String totalAmount;
    private List<String> avaliableMethods;

    public Checkout(String id, String url, String totalAmount, List<String> avaliableMethods) {
        super();
        this.id = id;
        this.url = url;
        this.totalAmount = totalAmount;
        this.avaliableMethods = avaliableMethods;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setAvaliableMethods(List<String> avaliableMethods) {
        this.avaliableMethods = avaliableMethods;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public List<String> getAvaliableMethods() {
        return avaliableMethods;
    }
}