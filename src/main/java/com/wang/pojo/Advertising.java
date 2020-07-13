package com.wang.pojo;

public class Advertising {
    private Integer advertisingid;

    private String title;
    private String imageurl;

    private String hrefurl;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getHrefurl() {
        return hrefurl;
    }

    public void setHrefurl(String hrefurl) {
        this.hrefurl = hrefurl == null ? null : hrefurl.trim();
    }
    public Integer getAdvertisingid() {
        return advertisingid;
    }

    public void setAdvertisingid(Integer advertisingid) {
        this.advertisingid = advertisingid;
    }

    public String getTitle() {
        return title;
    }

    @Override
	public String toString() {
		return "Advertising [advertisingid=" + advertisingid + ", title=" + title + ", imageurl=" + imageurl
				+ ", hrefurl=" + hrefurl + "]";
	}

	public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}