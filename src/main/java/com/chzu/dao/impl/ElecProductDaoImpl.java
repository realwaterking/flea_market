package com.chzu.dao.impl;

import com.chzu.bean.Product;
import com.chzu.dao.ProductDao;
import com.chzu.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ElecProductDaoImpl implements ProductDao {

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
    public boolean insert(Product product) {
        try {
            String sql = "insert into elecproduct(product_name, product_price, product_description, product_quantity) values (\"" + product.getProduct_name()
                    + "\",\"" + product.getProduct_price() + "\",\"" + product.getProduct_description() + "\",\""
                    + product.getProduct_quantity() +"\")";
            boolean status = stat.execute(sql);
            return !status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "delete from elecproduct where product_id = " + "\"" + id + "\"";
            boolean state = stat.execute(sql);
            return state;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            String sql = "update elecproduct set product_name = \"" + product.getProduct_name() + "\",product_price = \""
                    + product.getProduct_price() + "\", product_description = \"" + product.getProduct_description() + "\",product_quantity = \""
                    + product.getProduct_quantity() + "\" where product_id = \"" + product.getProduct_id() + "\"";
            boolean state = stat.execute(sql);
            return !state;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> selectAll(int cpage, int count) {
        try {
            String sql = "select * from elecproduct limit " + (cpage - 1) * count + "," + count;
            ResultSet rs = stat.executeQuery(sql);

            List<Product> listProduct = new ArrayList<>();
            System.out.println("liveproductdaoimpl调用了selectAll方法");

            while (rs.next()) {
                Product productTemp = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_price"),
                        rs.getString("product_description"),
                        rs.getInt("product_quantity")
                );
                listProduct.add(productTemp);
            }
            return listProduct;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int[] totalpage(int count) {
        try {
            int arr[]= {0,1};
            String sql = "select count(*) from elecproduct";
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
    public Product getById(int id) {
        try {
            String sql = "select * from elecproduct where product_id = " + id;
            ResultSet rs = stat.executeQuery(sql);
            Product productTemp = null;

            while (rs.next()) {
                productTemp = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_price"),
                        rs.getString("product_description"),
                        rs.getInt("product_quantity")
                );
            }
            return productTemp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
