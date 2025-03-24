package cn.demo_text3.service.impl;

import cn.demo_text3.entity.WxUserInfo;
import cn.demo_text3.mapper.WxUserInfoMapper;
import cn.demo_text3.service.IWxUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 微信用户Service实现类
@Service("WxUserInfoService")
public class IWxUserInfoServiceImpl extends ServiceImpl<WxUserInfoMapper, WxUserInfo> implements IWxUserInfoService {

    @Autowired
    private WxUserInfoMapper WxUserInfoMapper;
}
