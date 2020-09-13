package com.yc.crbook.dao;

import com.yc.crbook.bean.CrArticle;
import com.yc.crbook.bean.CrArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrArticleMapper {
    long countByExample(CrArticleExample example);

    int deleteByExample(CrArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrArticle record);

    int insertSelective(CrArticle record);

    List<CrArticle> selectByExampleWithBLOBs(CrArticleExample example);

    List<CrArticle> selectByExample(CrArticleExample example);

    CrArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrArticle record, @Param("example") CrArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") CrArticle record, @Param("example") CrArticleExample example);

    int updateByExample(@Param("record") CrArticle record, @Param("example") CrArticleExample example);

    int updateByPrimaryKeySelective(CrArticle record);

    int updateByPrimaryKeyWithBLOBs(CrArticle record);

    int updateByPrimaryKey(CrArticle record);
}