package cn.demo_text3.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@TableName("t_product")
@Data
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String productIntroImages;          //商品介绍图片
    private String productParaImages;           //商品规格参数图片
    private Integer stock;       //库存
    private String proPic = "default.jpg";    //商品图片
    private boolean isHot = false;   //是否为热门商品
    private boolean isSwiper = false;      //是否轮播图片
    private Integer swiperSort = 0;       //轮播排序
    private String swiperPic = "default.jpg";   //是否为轮播图图片
    private String description;  //商品描述

    @TableField(select = false)
    private List<ProductSwiperImage> productSwiperImageList;      //商品详细页轮播图片

    @JsonSerialize(using=CustomDateTimeSerializer.class)
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date hotDateTime;    //热门推荐日期时间

    @TableField(select = false)
    private SmallType type;  // 商品类别


    public List<ProductSwiperImage> getProductSwiperImageList() {
        return productSwiperImageList;
    }

    public void setProductSwiperImageList(List<ProductSwiperImage> productSwiperImageList) {
        this.productSwiperImageList = productSwiperImageList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductIntroImages() {
        return productIntroImages;
    }

    public void setProductIntroImages(String productIntroImages) {
        this.productIntroImages = productIntroImages;
    }

    public String getProductParaImages() {
        return productParaImages;
    }

    public void setProductParaImages(String productParaImages) {
        this.productParaImages = productParaImages;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProPic() {
        return proPic;
    }

    public void setProPic(String proPic) {
        this.proPic = proPic;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isSwiper() {
        return isSwiper;
    }

    public void setSwiper(boolean swiper) {
        isSwiper = swiper;
    }

    public Integer getSwiperSort() {
        return swiperSort;
    }

    public void setSwiperSort(Integer swiperSort) {
        this.swiperSort = swiperSort;
    }

    public String getSwiperPic() {
        return swiperPic;
    }

    public void setSwiperPic(String swiperPic) {
        this.swiperPic = swiperPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getHotDateTime() {
        return hotDateTime;
    }

    public void setHotDateTime(Date hotDateTime) {
        this.hotDateTime = hotDateTime;
    }


}
