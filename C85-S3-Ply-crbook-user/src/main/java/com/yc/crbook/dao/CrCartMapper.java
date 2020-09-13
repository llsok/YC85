package com.yc.crbook.dao;

import com.yc.crbook.bean.CrCart;
import com.yc.crbook.bean.CrCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrCartMapper {
    long countByExample(CrCartExample example);

    int deleteByExample(CrCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrCart record);

    int insertSelective(CrCart record);

    List<CrCart> selectByExample(CrCartExample example);

    CrCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrCart record, @Param("example") CrCartExample example);

    int updateByExample(@Param("record") CrCart record, @Param("example") CrCartExample example);

    int updateByPrimaryKeySelective(CrCart record);

    int updateByPrimaryKey(CrCart record);
}