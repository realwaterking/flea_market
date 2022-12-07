package com.chzu.dao.impl;

import com.chzu.bean.Client;
import com.chzu.dao.ClientDao;
import com.chzu.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    //获得数据库连接
    Connection conn = jdbcUtils.getConnection();
    Statement stat;
    {
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insert(Client client) {
        try {
            String sql = "insert into client(client_username, client_password, client_phoneNumber" +
                    ", client_QQ) values(\"" + client.getClient_username() + "\",\""
                    + client.getClient_password() + "\",\"" + client.getClient_phoneNumber()
                    + "\",\"" + client.getClient_QQ() + "\")";
            boolean state = false;
            state = stat.execute(sql);
            System.out.println("dao插入失败" + !state);

            return !state;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "delete from client where client_id = " + id;
            boolean status = stat.execute(sql);
            return status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Client client) {
        try {
            String sql = "update client set username = \"" + client.getClient_username() + "\",\""
                    + client.getClient_password() + "\",\"" + client.getClient_phoneNumber() + "\",\""
                    + client.getClient_QQ() + "\",\"" + client.getClient_status() + "\"";
            boolean status = stat.execute(sql);
            return status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> selectAll(int cpage, int count) {
        try {
            String sql = "select * from client limit " + (cpage - 1) * count + "," + count;
            ResultSet rs = stat.executeQuery(sql);
            List<Client> listClient = new ArrayList<>();
            Client clientTemp = null;

            while (rs.next()) {
                clientTemp = new Client(
                        rs.getInt("client_id"),
                        rs.getString("client_username"),
                        rs.getString("client_password"),
                        rs.getString("client_phoneNumber"),
                        rs.getString("client_QQ"),
                        rs.getString("client_status")
                );
                listClient.add(clientTemp);
            }
            return listClient;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int[] totalpage(int count) {
        try {
            int arr[]= {0,1};
            String sql = "select count(*) from client";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                arr[0]=rs.getInt(1);
                if(arr[0]%count==0) {
                    arr[1]=arr[0]/count;
                }else {
                    arr[1]=arr[0]/count+1;
                }
            }
            return arr;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client getById(int id) {
        try {
            String sql = "select * from client where client_id = " + id;
            ResultSet rs = stat.executeQuery(sql);
            Client clientTemp = null;

            while (rs.next()) {
                clientTemp = new Client(
                        rs.getInt("client_id"),
                        rs.getString("client_username"),
                        rs.getString("client_password"),
                        rs.getString("client_phoneNumber"),
                        rs.getString("client_QQ"),
                        rs.getString("client_status")
                );
            }
            return clientTemp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean selectByUsername(String username) {
        try {
            String sql = "select * from client where client_username = " + "\"" + username + "\"";

            boolean state = false;
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                state = true;
            }
            return state;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkout(Client client) {
        try {
            String sql = "select client_password from client where client_username = " + "\"" + client.getClient_username() + "\"";
            boolean b = selectByUsername(client.getClient_username());
            boolean state = false;

            if (b) {
                ResultSet rs = stat.executeQuery(sql);

                while (rs.next()) {
                    state = true;
                }
            }
            System.out.println(state + "  checkout的值");
            return state;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
