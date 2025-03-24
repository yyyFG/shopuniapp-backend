package cn.demo_text3.controller;

import cn.demo_text3.entity.Product;
import cn.demo_text3.entity.ProductSwiperImage;
import cn.demo_text3.entity.R;
import cn.demo_text3.service.IProductService;
import cn.demo_text3.service.IProductSwiperImageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductSwiperImageService productSwiperImageService;

    @GetMapping("/findSwiper")
    public R findSwiper(){
        List<Product> swiperProductList = productService.list(new QueryWrapper<Product>().eq("isSwiper",true).orderByAsc("swiperSort"));
        Map<String,Object> map = new HashMap<>();
        map.put("message",swiperProductList);
        return R.ok(map);
    }

    @GetMapping("/findHot")
    public R findHot(){
        Page<Product> page = new Page<>(1,9);
        Page<Product> pageProduct = productService.page(page,new QueryWrapper<Product>().eq("isHot",true).orderByAsc("HotDateTime"));
        List<Product> hotProductList = pageProduct.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("message",hotProductList);
        return R.ok(map);
    }

    //根据id查找商品信息
    @GetMapping("/detail")
    public R detail(Integer id){
        Product product =  productService.getById(id);
        List<ProductSwiperImage> productSwiperImageList = productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId", product.getId()).orderByAsc("sort"));
        product.setProductSwiperImageList(productSwiperImageList);
        Map<String,Object> map = new HashMap<>();
        map.put("message",product);
        return R.ok(map);
    }

    // 商品搜索
    @GetMapping("/search")
    public R search(String g){
        System.out.println(g);
        List<Product> productList = productService.list(new QueryWrapper<Product>().like("name", g));
        Map<String,Object> map = new HashMap<>();
        map.put("message",productList);
        return R.ok(map);
    }
}
