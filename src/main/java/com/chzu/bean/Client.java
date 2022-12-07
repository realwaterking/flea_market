package com.chzu.bean;

public class Client {

    private int client_id;
    private String client_username;
    private String client_password;
    private String client_phoneNumber;
    private String client_QQ;
    private String client_status;

    public Client() {
    }

    public Client(int client_id, String client_username, String client_password
            , String client_phoneNumber, String client_QQ, String client_status) {
        this.client_id = client_id;
        this.client_username = client_username;
        this.client_password = client_password;
        this.client_phoneNumber = client_phoneNumber;
        this.client_QQ = client_QQ;
        this.client_status = client_status;
    }

    public Client(String client_username, String client_password, String client_phoneNumber, String client_QQ) {
        this.client_username = client_username;
        this.client_password = client_password;
        this.client_phoneNumber = client_phoneNumber;
        this.client_QQ = client_QQ;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id='" + client_id + '\'' +
                ", client_username='" + client_username + '\'' +
                ", client_password='" + client_password + '\'' +
                ", client_phoneNumber='" + client_phoneNumber + '\'' +
                ", client_QQ='" + client_QQ + '\'' +
                ", client_status='" + client_status + '\'' +
                '}';
    }

    public int getClient_id() {
        return client_id;
    }

    public String getClient_username() {
        return client_username;
    }

    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

    public String getClient_password() {
        return client_password;
    }

    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }

    public String getClient_phoneNumber() {
        return client_phoneNumber;
    }

    public void setClient_phoneNumber(String client_phoneNumber) {
        this.client_phoneNumber = client_phoneNumber;
    }

    public String getClient_QQ() {
        return client_QQ;
    }

    public void setClient_QQ(String client_QQ) {
        this.client_QQ = client_QQ;
    }

    public String getClient_status() {
        return client_status;
    }

    public void setClient_status(String client_status) {
        this.client_status = client_status;
    }
}
