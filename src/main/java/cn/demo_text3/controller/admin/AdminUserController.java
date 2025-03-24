package cn.demo_text3.controller.admin;


import cn.demo_text3.entity.PageBean;
import cn.demo_text3.entity.R;
import cn.demo_text3.entity.WxUserInfo;
import cn.demo_text3.service.IWxUserInfoService;
import cn.demo_text3.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


//后台管理-用户Controller控制类
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private IWxUserInfoService iWxUserInfoService;


    // 根据条件分页查询用户信息
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        String query = pageBean.getQuery().trim();
        Page<WxUserInfo> page = new Page<>(pageBean.getPageNum(),pageBean.getPageSize());
        Page<WxUserInfo> pageResult = iWxUserInfoService.page(page, new QueryWrapper<WxUserInfo>().like(StringUtil.isNotEmpty(query), "nickName", query));
        Map<String,Object> map = new HashMap<>();
        map.put("userList",pageResult.getRecords());
        map.put("total",pageResult.getTotal());
        return R.ok(map);
    }
}
