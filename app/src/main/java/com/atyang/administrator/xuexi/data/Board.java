package com.atyang.administrator.xuexi.data;

import cn.bmob.v3.BmobObject;

/**
 * 留言板的主要的类
 * Created by Administrator on 2016/7/18.
 */
public class Board extends BmobObject {
    /**留言板内容*/
    private String mdatacontent;
    /**留言的人*/
    private String mperson;
    /**留言的时间*/
    private String mtime;
    /**查询的分类*/
    private String leibie;

    public String getMdatacontent() {
        return mdatacontent;
    }

    public String getMperson() {
        return mperson;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMdatacontent(String mdatacontent) {
        this.mdatacontent = mdatacontent;
    }

    public void setMperson(String mperson) {
        this.mperson = mperson;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public Board() {
    }

    public Board(String mdatacontent, String mperson, String mtime, String leibie) {
        this.mdatacontent = mdatacontent;
        this.mperson = mperson;
        this.mtime = mtime;
        this.leibie = leibie;
    }

    @Override
    public String toString() {
        return "Board{" +
                "mdatacontent='" + mdatacontent + '\'' +
                ", mperson='" + mperson + '\'' +
                ", mtime='" + mtime + '\'' +
                ", leibie='" + leibie + '\'' +
                '}';
    }
}
