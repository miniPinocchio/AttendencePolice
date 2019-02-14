package com.anrongtec.attendencepolice.bean;

import java.util.List;

/**
 * @author Created by huiliu on 2019/1/18.
 * @email liu594545591@126.com
 * @introduce
 */
public class BaseRankData {
    private String msg;
    private String status;
    private List<RankData> rows;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RankData> getRows() {
        return rows;
    }

    public void setRows(List<RankData> rows) {
        this.rows = rows;
    }
}
