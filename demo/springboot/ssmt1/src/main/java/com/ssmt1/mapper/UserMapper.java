package com.ssmt1.mapper;

import com.ssmt1.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface UserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from t_user where userId = #{userId}")
    User selectById(int userId);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from t_user")
    List<User> selectAll();

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into t_user (userName,password,phone) values(#{userName},#{password},#{phone})")
    void addUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    @Delete("delete from  t_user where userId =#{userId}")
    void deleteUser(int userId);

}
