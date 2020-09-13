package com.yc.crbook.bean;

public class CrBookWithBLOBs extends CrBook {
    private String abst;

    private String contentIntro;

    private String authorIntro;

    private String catalog;

    private String extract;

    public String getAbst() {
        return abst;
    }

    public void setAbst(String abst) {
        this.abst = abst == null ? null : abst.trim();
    }

    public String getContentIntro() {
        return contentIntro;
    }

    public void setContentIntro(String contentIntro) {
        this.contentIntro = contentIntro == null ? null : contentIntro.trim();
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro == null ? null : authorIntro.trim();
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract == null ? null : extract.trim();
    }
}