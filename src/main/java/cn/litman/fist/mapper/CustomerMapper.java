package cn.litman.fist.mapper;

import cn.litman.fist.entity.Customer;

public interface CustomerMapper {

    Boolean insertCustomer(Customer customer);

    Boolean updateCustomer(Customer customer);
}