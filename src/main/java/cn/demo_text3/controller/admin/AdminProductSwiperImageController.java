package cn.demo_text3.controller.admin;


import cn.demo_text3.entity.ProductSwiperImage;
import cn.demo_text3.entity.R;
import cn.demo_text3.service.IProductSwiperImageService;
import cn.demo_text3.util.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 产品轮播图Controller控制器
@RestController
@RequestMapping("/admin/productSwiperImage")
public class AdminProductSwiperImageController {
    
    @Autowired
    private IProductSwiperImageService productSwiperImageService;

    @Value("${productSwiperImagesFilePath}")
    private String productSwiperImagesFilePath;


    // 查询所属产品
    @GetMapping("/list/{id}")
    public R list(@PathVariable(value = "id")Integer id){
        List<ProductSwiperImage> list = productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId", id));

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        
        return R.ok(resultMap);
    }


    // 添加或修改产品轮播图
    @PostMapping("/save")
    public R save(@RequestBody ProductSwiperImage productSwiperImage){
        productSwiperImageService.saveOrUpdate(productSwiperImage);

        return R.ok();
    }

    // 删除订单
    @GetMapping("/delete/{id}")
    public R delete(@PathVariable(value = "id")Integer id){
        productSwiperImageService.removeById(id);
        return R.ok();
    }

    // 更新商品大类图片
    @RequestMapping("/uploadImage")
    public Map<String,Object> uploadImage(MultipartFile file) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();

        if(!file.isEmpty()){
            // 获取文件名
            String originalFilename = file.getOriginalFilename();
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr()+suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(productSwiperImagesFilePath+newFileName));
            resultMap.put("code",0);
            resultMap.put("msg","上传成功");
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("title",newFileName);
            dataMap.put("src","/image/productSwiperImgs/"+newFileName);
            resultMap.put("data",dataMap);
        }

        return resultMap;
    }

}
