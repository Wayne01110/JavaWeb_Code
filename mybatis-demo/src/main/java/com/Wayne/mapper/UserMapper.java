package com.Wayne.mapper;

import com.Wayne.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Connection;
import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);

    /*
       Mybatis 参数封装：
        * 单个参数：单个参数又可以是如下类型
           1. POJO 类型：直接使用，属性名 和 参数占位符名称 一致
           2. Map 集合类型：直接使用，键名 和 参数占位符名称 一致
           3. Collection 集合类型：封装为Map集合,可以使用 @Param 注解替换map集合中默认的 arg 键名。
                map.put("arg0"，collection集合);
                map.put("collection"，collection集合;

           4. List 集合类型：封装为Map集合,可以使用 @Param 注解替换map集合中默认的 arg 键名。
                map.put("arg0"，list集合);
                map.put("collection"，list集合);
                map.put("list"，list集合);

           5. Array 类型：封装为Map集合,可以使用 @Param 注解替换map集合中默认的 arg 键名。
                map.put("arg0"，数组);
                map.put("array"，数组);

           6. 其他类型：比如int类型， 参数占位符名称 叫什么都可以。尽量做到见名知意

        * 多个参数：封装为Map集合,可以使用 @Param 注解替换map集合中默认的 arg 键名。
            map.put("arg0",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)

    */
    User select(@Param("username") String username, String passwoed);

    User select(Connection collection);

}
