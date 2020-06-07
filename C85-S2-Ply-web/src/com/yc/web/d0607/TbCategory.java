package com.yc.web.d0607;

public class TbCategory {
    private Integer id;

    private Byte level;

    private Integer parentId;

    private String zh;

    private String ru;

    private String pt;

    private String en;

    private Integer sort;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh == null ? null : zh.trim();
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru == null ? null : ru.trim();
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt == null ? null : pt.trim();
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en == null ? null : en.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}