package cn.demo_text3.controller.admin;

import cn.demo_text3.entity.BigType;
import cn.demo_text3.entity.SmallType;
import cn.demo_text3.entity.PageBean;
import cn.demo_text3.entity.R;
import cn.demo_text3.service.IBigTypeService;
import cn.demo_text3.service.ISmallTypeService;
import cn.demo_text3.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 管理员-订单Controller控制器
@RestController
@RequestMapping("/admin/smallType")
public class AdminSmallTypeController {

    @Autowired
    private ISmallTypeService smallTypeService;

    @Autowired
    private IBigTypeService bigTypeService;


    // 根据条件分页查询
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean.getPageNum());
        System.out.println(pageBean.getPageSize());

        Map<String,Object> map = new HashMap<>();
        map.put("name", pageBean.getQuery().trim());
        if(pageBean.getPageNum()==1) map.put("start", pageBean.getStart());
        else map.put("start", pageBean.getPageNum()+ pageBean.getPageSize());

        map.put("pageSize", pageBean.getPageSize());

        List<SmallType> smallTypeList = smallTypeService.list(map);
        Long total = smallTypeService.getTotal(map);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("smallTypeList",smallTypeList);
        resultMap.put("total",total);

        return R.ok(resultMap);

    }


    // 删除订单
    @GetMapping("/delete/{id}")
    public R delete(@PathVariable(value = "id")Integer id){
        smallTypeService.removeById(id);
        return R.ok();
    }


    // 添加或修改商品大类
    @PostMapping("/save")
    public R save(@RequestBody SmallType smallType){
        smallType.setBigTypeId(smallType.getBigType().getId());
        if(smallType.getId()==null || smallType.getId()==-1){
            smallTypeService.save(smallType);
        }else {
            smallTypeService.saveOrUpdate(smallType);
        }

        return R.ok();
    }

    // 根据id查询数据
    @GetMapping("/{id}")
    public R findById(@PathVariable(value = "id")Integer id){
        SmallType smallType = smallTypeService.getById(id);
        smallType.setBigType(bigTypeService.getById(smallType.getBigTypeId()));
        Map<String,Object> map = new HashMap<>();
        map.put("smallType",smallType);

        return R.ok(map);
    }

    // 根据商品大类id 查询所有小类
    @GetMapping("/listAll/{bigTypeId}")
    public R listAll(@PathVariable(value = "bigTypeId")Integer bigTypeId){
        Map<String,Object> map = new HashMap<>();
        List<SmallType> smallTypeList = smallTypeService.list(new QueryWrapper<SmallType>().eq("bigTypeId", bigTypeId));
        map.put("smallTypeList",smallTypeList);
        return R.ok(map);
    }

}
