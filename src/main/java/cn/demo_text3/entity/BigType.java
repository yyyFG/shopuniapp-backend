package cn.demo_text3.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;


//商品大类
@TableName("t_bigtype")
@Data
public class BigType {
    private Integer id;
    private String name;
    private String remark;
    private String image = "default.jpg";  //封面图片

    @TableField(select = false)
    private List<SmallType> smallTypeList;  //商品小类集合

    public List<SmallType> getSmallTypeList() {
        return smallTypeList;
    }

    public BigType() {
    }

    public BigType(Integer id, String name, String remark) {
        this.id = id;
        this.name = name;
        this.remark = remark;
    }

    public void setSmallTypeList(List<SmallType> smallTypeList) {
        this.smallTypeList = smallTypeList;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
