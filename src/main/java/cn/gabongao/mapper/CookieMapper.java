package cn.gabongao.mapper;

import cn.gabongao.model.CookiePOJO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * Created by Imgaojp on 2018/9/1.
 */
@Mapper
@Component
public interface CookieMapper {
    // 插入 并查询id 赋给传入的对象
//    @Insert("INSERT INTO tb_test(key, value) VALUES(#{key}, #{value})")
//    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'tb_test')", before = false, keyProperty = "id", resultType = int.class)
//    int insert(CookiePOJO cookie);


    @Insert("insert into cookie (url,cookies) values (#{url},#{cookies})")
    int insert(CookiePOJO cookiePOJO1);

    //
//    // 根据 ID 查询
//    @Select("SELECT * FROM tb_test WHERE id=#{id}")
//    CookiePOJO select(String site);
//
    // 查询全部
    @Select("SELECT * FROM cookie")
    List<CookiePOJO> selectAll();

    @Delete("delete from cookie where url=#{host}")
    void remove(String host);
//
//    // 更新 value
//    @Update("UPDATE tb_test SET value=#{value} WHERE id=#{id}")
//    int updateValue(CookiePOJO cookie);
//
//    // 根据 ID 删除
//    @Delete("DELETE FROM tb_test WHERE id=#{id}")
//    int delete(String site);

}
