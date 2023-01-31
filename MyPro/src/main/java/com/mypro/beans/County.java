package com.mypro.beans;

import java.io.Serializable;

public class County implements Serializable {
    private Long countyId;

    private String province;

    private String city;

    private String county;

    private static final long serialVersionUID = 1L;

    public County(Long countyId, String province, String city, String county) {
        this.countyId = countyId;
        this.province = province;
        this.city = city;
        this.county = county;
    }

    public Long getCountyId() {
        return countyId;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countyId=").append(countyId);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}