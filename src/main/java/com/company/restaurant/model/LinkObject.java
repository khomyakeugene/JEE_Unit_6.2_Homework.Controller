package com.company.restaurant.model;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class LinkObject {
    private int firstId;
    private int secondId;
    protected String linkData;

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public String getLinkData() {
        return linkData;
    }

    public void setLinkData(String linkData) {
        this.linkData = linkData;
    }
}
