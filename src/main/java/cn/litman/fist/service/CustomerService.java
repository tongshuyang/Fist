package cn.litman.fist.service;

import cn.litman.fist.common.PageMsg;
import cn.litman.fist.common.ReturnMsg;
import cn.litman.fist.entity.Customer;

/**
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 0:54
 */
public interface CustomerService {

    /**
     * 添加客户信息
     *
     * @param customer 顾客实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/23 23:19
     */
    ReturnMsg addCustomer(Customer customer);

    /**
     * 查询客户列表
     *
     * @param customer 顾客实体类
     * @param page 页码
     * @param limit 每页条数
     * @return cn.litman.fist.common.PageMsg
     * @author SoyungTong
     * @date 2021/5/23 23:30
     */
    PageMsg listCustomer(Customer customer, Integer page, Integer limit);

    /**
     * 修改客户信息
     *
     * @param customer 顾客实体类
     * @return cn.litman.fist.common.ReturnMsg
     * @author SoyungTong
     * @date 2021/5/23 23:31
     */
    ReturnMsg altCustomer(Customer customer);

}
