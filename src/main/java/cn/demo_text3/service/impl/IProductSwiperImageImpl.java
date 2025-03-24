package cn.demo_text3.service.impl;

import cn.demo_text3.entity.ProductSwiperImage;
import cn.demo_text3.mapper.ProductSwiperImageMapper;
import cn.demo_text3.service.IProductSwiperImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProductSwiperImageService")
public class IProductSwiperImageImpl extends ServiceImpl<ProductSwiperImageMapper, ProductSwiperImage> implements IProductSwiperImageService {

    @Autowired
    private ProductSwiperImageMapper ProductSwiperImageMapper;
}
