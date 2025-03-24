package cn.demo_text3.service.impl;

import cn.demo_text3.entity.OrderDetail;
import cn.demo_text3.mapper.OrderDetailMapper;
import cn.demo_text3.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 订单详情Service实现类
@Service("OrderDetailService")
public class IOrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

    @Autowired
    private OrderDetailMapper OrderDetailMapper;
}
