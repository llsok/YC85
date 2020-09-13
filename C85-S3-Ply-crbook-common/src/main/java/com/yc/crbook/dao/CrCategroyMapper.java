package com.yc.crbook.dao;

import com.yc.crbook.bean.CrCategroy;
import com.yc.crbook.bean.CrCategroyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrCategroyMapper {
    long countByExample(CrCategroyExample example);

    int deleteByExample(CrCategroyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrCategroy record);

    int insertSelective(CrCategroy record);

    List<CrCategroy> selectByExample(CrCategroyExample example);

    CrCategroy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrCategroy record, @Param("example") CrCategroyExample example);

    int updateByExample(@Param("record") CrCategroy record, @Param("example") CrCategroyExample example);

    int updateByPrimaryKeySelective(CrCategroy record);

    int updateByPrimaryKey(CrCategroy record);
}