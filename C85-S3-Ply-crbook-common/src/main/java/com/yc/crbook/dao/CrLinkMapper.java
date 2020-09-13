package com.yc.crbook.dao;

import com.yc.crbook.bean.CrLink;
import com.yc.crbook.bean.CrLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrLinkMapper {
    long countByExample(CrLinkExample example);

    int deleteByExample(CrLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrLink record);

    int insertSelective(CrLink record);

    List<CrLink> selectByExample(CrLinkExample example);

    CrLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrLink record, @Param("example") CrLinkExample example);

    int updateByExample(@Param("record") CrLink record, @Param("example") CrLinkExample example);

    int updateByPrimaryKeySelective(CrLink record);

    int updateByPrimaryKey(CrLink record);
}