package com.qiu.dmp.model;

/**
 * Created by Administrator on 2016/8/23.
 */
public class Brand {
    private int id;
    private String name;
    private String ename;
    private String ALIAS;
    private String source;
    private String created;
    private String site;
    private String business;
    private String intro;
    private String pimgurl;
    private String plistid;
    private String imgurl;
    private String url;
    private String naiyuan;
    private String chandi;
    private String letter;
    private int is_valid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getALIAS() {
        return ALIAS;
    }

    public void setALIAS(String ALIAS) {
        this.ALIAS = ALIAS;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPimgurl() {
        return pimgurl;
    }

    public void setPimgurl(String pimgurl) {
        this.pimgurl = pimgurl;
    }

    public String getPlistid() {
        return plistid;
    }

    public void setPlistid(String plistid) {
        this.plistid = plistid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNaiyuan() {
        return naiyuan;
    }

    public void setNaiyuan(String naiyuan) {
        this.naiyuan = naiyuan;
    }

    public String getChandi() {
        return chandi;
    }

    public void setChandi(String chandi) {
        this.chandi = chandi;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (getId() != brand.getId()) return false;
        if (getIs_valid() != brand.getIs_valid()) return false;
        if (getName() != null ? !getName().equals(brand.getName()) : brand.getName() != null) return false;
        if (getEname() != null ? !getEname().equals(brand.getEname()) : brand.getEname() != null) return false;
        if (getALIAS() != null ? !getALIAS().equals(brand.getALIAS()) : brand.getALIAS() != null) return false;
        if (getSource() != null ? !getSource().equals(brand.getSource()) : brand.getSource() != null) return false;
        if (getCreated() != null ? !getCreated().equals(brand.getCreated()) : brand.getCreated() != null) return false;
        if (getSite() != null ? !getSite().equals(brand.getSite()) : brand.getSite() != null) return false;
        if (getBusiness() != null ? !getBusiness().equals(brand.getBusiness()) : brand.getBusiness() != null)
            return false;
        if (getIntro() != null ? !getIntro().equals(brand.getIntro()) : brand.getIntro() != null) return false;
        if (getPimgurl() != null ? !getPimgurl().equals(brand.getPimgurl()) : brand.getPimgurl() != null) return false;
        if (getPlistid() != null ? !getPlistid().equals(brand.getPlistid()) : brand.getPlistid() != null) return false;
        if (getImgurl() != null ? !getImgurl().equals(brand.getImgurl()) : brand.getImgurl() != null) return false;
        if (getUrl() != null ? !getUrl().equals(brand.getUrl()) : brand.getUrl() != null) return false;
        if (getNaiyuan() != null ? !getNaiyuan().equals(brand.getNaiyuan()) : brand.getNaiyuan() != null) return false;
        if (getChandi() != null ? !getChandi().equals(brand.getChandi()) : brand.getChandi() != null) return false;
        return getLetter() != null ? getLetter().equals(brand.getLetter()) : brand.getLetter() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEname() != null ? getEname().hashCode() : 0);
        result = 31 * result + (getALIAS() != null ? getALIAS().hashCode() : 0);
        result = 31 * result + (getSource() != null ? getSource().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getSite() != null ? getSite().hashCode() : 0);
        result = 31 * result + (getBusiness() != null ? getBusiness().hashCode() : 0);
        result = 31 * result + (getIntro() != null ? getIntro().hashCode() : 0);
        result = 31 * result + (getPimgurl() != null ? getPimgurl().hashCode() : 0);
        result = 31 * result + (getPlistid() != null ? getPlistid().hashCode() : 0);
        result = 31 * result + (getImgurl() != null ? getImgurl().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getNaiyuan() != null ? getNaiyuan().hashCode() : 0);
        result = 31 * result + (getChandi() != null ? getChandi().hashCode() : 0);
        result = 31 * result + (getLetter() != null ? getLetter().hashCode() : 0);
        result = 31 * result + getIs_valid();
        return result;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                ", ALIAS='" + ALIAS + '\'' +
                ", source='" + source + '\'' +
                ", created='" + created + '\'' +
                ", site='" + site + '\'' +
                ", business='" + business + '\'' +
                ", intro='" + intro + '\'' +
                ", pimgurl='" + pimgurl + '\'' +
                ", plistid='" + plistid + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", url='" + url + '\'' +
                ", naiyuan='" + naiyuan + '\'' +
                ", chandi='" + chandi + '\'' +
                ", letter='" + letter + '\'' +
                ", is_valid=" + is_valid +
                '}';
    }
}
