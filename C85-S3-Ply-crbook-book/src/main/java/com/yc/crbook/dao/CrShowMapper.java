package com.yc.crbook.dao;

import com.yc.crbook.bean.CrShow;
import com.yc.crbook.bean.CrShowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrShowMapper {
    long countByExample(CrShowExample example);

    int deleteByExample(CrShowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrShow record);

    int insertSelective(CrShow record);

    List<CrShow> selectByExample(CrShowExample example);

    CrShow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrShow record, @Param("example") CrShowExample example);

    int updateByExample(@Param("record") CrShow record, @Param("example") CrShowExample example);

    int updateByPrimaryKeySelective(CrShow record);

    int updateByPrimaryKey(CrShow record);
}