package cn.demo_text3.mapper;

import cn.demo_text3.entity.BigType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface BigTypeMapper extends BaseMapper<BigType> {

    public BigType findById(Integer id);
}
