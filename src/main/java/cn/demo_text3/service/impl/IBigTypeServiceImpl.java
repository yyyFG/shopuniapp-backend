package cn.demo_text3.service.impl;

import cn.demo_text3.entity.BigType;
import cn.demo_text3.mapper.BigTypeMapper;
import cn.demo_text3.service.IBigTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BigTypeService")
public class IBigTypeServiceImpl extends ServiceImpl<BigTypeMapper, BigType> implements IBigTypeService {

    @Autowired
    private BigTypeMapper BigTypeMapper;
}
