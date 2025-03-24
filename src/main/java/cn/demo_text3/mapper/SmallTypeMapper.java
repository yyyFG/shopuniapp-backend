package cn.demo_text3.mapper;

import cn.demo_text3.entity.BigType;
import cn.demo_text3.entity.SmallType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


//商品小类mapper接口
public interface SmallTypeMapper extends BaseMapper<SmallType> {

    List<SmallType> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    public SmallType findById(Integer id);

}
