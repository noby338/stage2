package priv.noby.jspmod.mapper;

import priv.noby.jspmod.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    public List<Brand> selectAll();

    @Select("select * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    public Brand selectById(int id);

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    public void add(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    public void deleteById(Brand brand);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    public void updateById(Brand brand);
}
