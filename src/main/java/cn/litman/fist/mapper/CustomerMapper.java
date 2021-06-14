package cn.litman.fist.mapper;

import cn.litman.fist.entity.Customer;
import java.util.List;

/**
 * 客户信息映射接口
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/6/14 23:15
 */
public interface CustomerMapper {

    /**
     * 添加客户信息
     *
     * @param customer 顾客实体类
     * @return java.lang.Boolean
     * @author SoyungTong
     * @date 2021/6/14 23:16
     */
    Boolean insertCustomer(Customer customer);

    /**
     * 查询客户列表
     *
     * @param customer 顾客实体类
     * @return java.util.List<cn.litman.fist.entity.Customer>
     * @author SoyungTong
     * @date 2021/6/14 23:17
     */
    List<Customer> listCustomer(Customer customer);

    /**
     * 修改客户信息
     *
     * @param customer 顾客实体类
     * @return java.lang.Boolean
     * @author SoyungTong
     * @date 2021/6/14 23:17
     */
    Boolean updateCustomer(Customer customer);
}