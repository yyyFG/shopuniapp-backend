package cn.demo_text3.service;

import cn.demo_text3.entity.SmallType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;


//商品小类service接口
public interface ISmallTypeService extends IService<SmallType> {
    List<SmallType> list(Map<String,Object> map);

    Long getTotal(Map<String, Object> map);
}
