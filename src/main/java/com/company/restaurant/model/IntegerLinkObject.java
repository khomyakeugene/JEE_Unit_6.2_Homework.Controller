package com.company.restaurant.model;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class IntegerLinkObject extends LinkObject {
    public int getIntegerLinkData() {
        return Integer.parseInt(linkData);
    }

    public void setIntegerLinkData(int intValue) {
        this.linkData = Integer.toString(intValue);
    }
}
