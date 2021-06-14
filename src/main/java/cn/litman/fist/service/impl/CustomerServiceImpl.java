package cn.litman.fist.service.impl;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.Customer;
import cn.litman.fist.mapper.CustomerMapper;
import cn.litman.fist.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 0:52
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ReturnMsg addCustomer(Customer customer) {
        return null;
    }

    @Override
    public PageMsg listCustomer(Customer customer, Integer page, Integer limit) {
        return null;
    }

    @Override
    public ReturnMsg altCustomer(Customer customer) {
        return null;
    }
}
