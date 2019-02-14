package com.anrongtec.attendencepolice.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Created by huiliu on 2019/1/17.
 * @email liu594545591@126.com
 * @introduce
 */
public class RankData implements Comparable<RankData> {

    private int rank;
    @SerializedName("name")
    private String companyName;
    @SerializedName("rs_num")
    private int signedPerson;
    @SerializedName("dk_num")
    private int allPerson;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSignedPerson() {
        return signedPerson;
    }

    public void setSignedPerson(int signedPerson) {
        this.signedPerson = signedPerson;
    }

    public int getAllPerson() {
        return allPerson;
    }

    public void setAllPerson(int allPerson) {
        this.allPerson = allPerson;
    }

    @Override
    public int compareTo(RankData rankData) {
        return rankData.getSignedPerson() - this.signedPerson;
    }
}
