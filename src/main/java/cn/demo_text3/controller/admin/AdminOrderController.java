package cn.demo_text3.controller.admin;


import cn.demo_text3.entity.Order;
import cn.demo_text3.entity.OrderDetail;
import cn.demo_text3.entity.PageBean;
import cn.demo_text3.entity.R;
import cn.demo_text3.service.IOrderDetailService;
import cn.demo_text3.service.IOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 管理员-订单Controller控制器
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    // 根据条件分页查询
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("orderNo", pageBean.getQuery().trim());
        map.put("start", pageBean.getPageNum());
        map.put("pageSize", pageBean.getPageSize());

        List<Order> orderList = orderService.list(map);
        Long total = orderService.getTotal(map);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("orderList",orderList);
        resultMap.put("total",total);

        return R.ok(resultMap);
    }

    // 更新订单状态
    @PostMapping("/updateStatus")
    public R updateStatus(@RequestBody Order order){
        Order resultOrder = orderService.getById(order.getId());
        resultOrder.setStatus(order.getStatus());
        orderService.saveOrUpdate(resultOrder);
        return R.ok();
    }

    // 删除订单
    @GetMapping("/delete/{id}")
    public R delete(@PathVariable(value = "id")Integer id){
        // 删除订单细表数据
        orderDetailService.remove(new QueryWrapper<OrderDetail>().eq("mId",id));
        orderService.removeById(id);

        return R.ok();
    }

}
