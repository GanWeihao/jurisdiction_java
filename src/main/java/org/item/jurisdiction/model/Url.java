package org.item.jurisdiction.model;

public class Url {
    private String urlId;

    private String urlName;

    public Url(String urlId, String urlName) {
        this.urlId = urlId;
        this.urlName = urlName;
    }

    public Url() {
    }

    public String getUrlId() {
        return this.urlId;
    }


    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }


    public String getUrlName() {
        return this.urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }
}