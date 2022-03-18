package com.itheima.Dao;

import com.itheima.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
    Customer findCustomerByNameAndJobs(Customer customer);

    Customer findCustomerByNameOrJobs(Customer customer);

    Boolean updateCustomerBySet(Customer customer);

    Customer findByList(List list);

    Customer findByMap(Map map);
}
