package com.example.lv617.lv617test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataSourceMapper {
    /**
     *  描述：根据表名称获取表的详细信息
     *
     *@创建人  lv617
     *@创建时间  2018/9/4 16:55
     */
    @Select("SHOW FULL FIELDS FROM ${dbName}.${tableName}")
    List<Map<String, Object>> getDataDetail(@Param("dbName") String dbName,@Param("tableName") String tableName);

    /**
     *  描述：根据数据库名称获取数据库中表的名称和注释
     *
     *@创建人  lv617
     *@创建时间  2018/9/4 16:55
     */
    @Select("select table_name,table_comment from information_schema.tables where table_schema = #{dbName}")
    List<Map<String, Object>> getAllDataSourceName(@Param("dbName") String dbName);
}
