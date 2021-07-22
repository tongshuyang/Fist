package cn.litman.fist.service.impl;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.Customer;
import cn.litman.fist.mapper.CustomerMapper;
import cn.litman.fist.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.Validate;
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
        //添加客户信息
        if(customerMapper.insertCustomer(customer)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }

    @Override
    public PageMsg listCustomer(Customer customer, Integer page, Integer limit) {
        //参数验证
        Validate.notNull(page);
        Validate.notNull(limit);
        //分页并返回结果
        PageHelper.startPage(page,limit);
        PageInfo<Customer> listCustomer = new PageInfo<>(customerMapper.listCustomer(customer));
        return new PageMsg(listCustomer.getTotal(),listCustomer.getList());
    }

    @Override
    public ReturnMsg altCustomer(Customer customer) {
        //更新客户信息
        if(customerMapper.updateCustomer(customer)){
            return ReturnMsg.SUCCESS;
        }
        return ReturnMsg.FAIL;
    }
}
