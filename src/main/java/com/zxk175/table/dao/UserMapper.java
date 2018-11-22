package com.zxk175.table.dao;

import com.zxk175.table.pojo.User;
import com.zxk175.table.pojo.UserExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user (id, user_name, ",
        "user_phone, user_email, ",
        "user_pwd, user_sex, ",
        "create_time, modify_time, ",
        "is_delete)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{userPhone,jdbcType=VARCHAR}, #{userEmail,jdbcType=VARCHAR}, ",
        "#{userPwd,jdbcType=VARCHAR}, #{userSex,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=VARCHAR}, #{modifyTime,jdbcType=VARCHAR}, ",
        "#{isDelete,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_pwd", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="modify_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_delete", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, user_name, user_phone, user_email, user_pwd, user_sex, create_time, modify_time, ",
        "is_delete",
        "from t_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_pwd", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="modify_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_delete", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(String id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update t_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_phone = #{userPhone,jdbcType=VARCHAR},",
          "user_email = #{userEmail,jdbcType=VARCHAR},",
          "user_pwd = #{userPwd,jdbcType=VARCHAR},",
          "user_sex = #{userSex,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=VARCHAR},",
          "is_delete = #{isDelete,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}