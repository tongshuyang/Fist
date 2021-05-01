package cn.litman.fist.mapper;

import cn.litman.fist.entity.Customer;

public interface CustomerMapper {
    int insert(Customer record);

    int insertSelective(Customer record);
}