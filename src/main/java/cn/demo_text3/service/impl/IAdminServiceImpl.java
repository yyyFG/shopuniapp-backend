package cn.demo_text3.service.impl;

import cn.demo_text3.entity.Admin;
import cn.demo_text3.mapper.AdminMapper;
import cn.demo_text3.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 管理员Service实现类
@Service("AdminService")
public class IAdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper AdminMapper;
}
