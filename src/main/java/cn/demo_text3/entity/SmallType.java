package cn.demo_text3.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

//商品小类
@TableName("t_smalltype")
@Data
public class SmallType {
    private Integer id;
    private String name;
    private String remark;
    private Integer bigTypeId;   //大类id

    @TableField(select = false, insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private BigType bigType;   //所属商品大类

    @TableField(select = false)
    private List<Product> productList;   //商品集合


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBigTypeId() {
        return bigTypeId;
    }

    public void setBigTypeId(Integer bigTypeId) {
        this.bigTypeId = bigTypeId;
    }

    public BigType getBigType() {
        return bigType;
    }

    public void setBigType(BigType bigType) {
        this.bigType = bigType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
