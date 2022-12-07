package com.chzu.dao;

import com.chzu.bean.Product;

import java.util.List;

public interface ProductDao {

    /**
     * 添加商品方法
     * @param product
     * @return
     */
    boolean insert(Product product) ;

    /**
     * 根据id删除指定商品
     * @param id
     * @return
     */
    boolean delete(int id) ;

    /**
     * 修改商品的方法
     * @param product
     * @return
     */
    boolean update(Product product) ;

    /**
     * 查询所有商品的方法
     * @param cpage
     * @param count
     * @return
     */
    List<Product> selectAll(int cpage, int count) ;

    /**
     * 查询总记录数的方法
     * @param count
     * @return
     */
    int[] totalpage(int count) ;

    /**
     * 根据id查询单个商品的方法
     * @param id
     * @return
     */
    Product getById(int id) ;


}
