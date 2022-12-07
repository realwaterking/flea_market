package com.chzu.dao;

import com.chzu.bean.Client;

import java.util.List;

public interface ClientDao {

    /**
     * 添加商品方法
     * @param client
     * @return
     */
    boolean insert(Client client) ;

    /**
     * 根据id删除指定商品
     * @param id
     * @return
     */
    boolean delete(int id) ;

    /**
     * 修改商品的方法
     * @param client
     * @return
     */
    boolean update(Client client) ;

    /**
     * 查询所有商品的方法
     * @param cpage
     * @param count
     * @return
     */
    List<Client> selectAll(int cpage, int count);

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
    Client getById(int id) ;

    /**
     *
     * @param username
     * @return
     */
    boolean selectByUsername(String username) ;

    /**
     * 登录方法
     * @param client
     * @return
     */
    boolean checkout(Client client) ;

}
