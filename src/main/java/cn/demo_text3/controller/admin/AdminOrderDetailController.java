package cn.demo_text3.controller.admin;


import cn.demo_text3.entity.OrderDetail;
import cn.demo_text3.entity.R;
import cn.demo_text3.service.IOrderDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 管理员订单详情Controller控制类
@RestController
@RequestMapping("/admin/orderDetail")
public class AdminOrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;


    // 根据订单号查询商品订单详情
    @RequestMapping("/list/{id}")
    public R listByOrderId(@PathVariable(value = "id")Integer id){
        List<OrderDetail> orderDateList = orderDetailService.list(new QueryWrapper<OrderDetail>().eq("mID", id));
        Map<String,Object> map = new HashMap<>();
        map.put("list",orderDateList);

        return R.ok(map);
    }
}
