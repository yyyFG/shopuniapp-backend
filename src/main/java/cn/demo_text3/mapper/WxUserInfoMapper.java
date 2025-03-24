package cn.demo_text3.mapper;

import cn.demo_text3.entity.WxUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

//微信用户信息mapper接口
public interface WxUserInfoMapper extends BaseMapper<WxUserInfo> {


    public WxUserInfo findByOpenId(String openId);
}
