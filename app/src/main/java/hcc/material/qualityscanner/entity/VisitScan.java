package hcc.material.qualityscanner.entity;

import java.io.Serializable;

public class VisitScan implements Serializable {
    private String msg;

    public VisitScan(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
