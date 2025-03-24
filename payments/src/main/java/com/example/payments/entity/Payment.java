package com.example.payments.entity;



public class Payment {
    private String id;
    private float monto;
    private String clienteId;
    private String ownerId;

    public Payment(String id, float monto, String ownerId, String clienteId) {
        this.id = id;
        this.monto = monto;
        this.ownerId = ownerId;
        this.clienteId = clienteId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
