package com.company.restaurant.model;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class FloatLinkObject extends LinkObject  {
    public float getFloatLinkData() {
        return Float.parseFloat(linkData);
    }

    public void setFloatLinkData(float floatValue) {
        this.linkData = Float.toString(floatValue);
    }
}
