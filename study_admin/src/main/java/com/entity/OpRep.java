package com.entity;

public class OpRep {

    private String serialNo;

    private String hostReturnCode;

    private String hostErrorMessage;

    private int turnPageTotalNum;

    private RepParam RepParam;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getHostReturnCode() {
        return hostReturnCode;
    }

    public void setHostReturnCode(String hostReturnCode) {
        this.hostReturnCode = hostReturnCode;
    }

    public String getHostErrorMessage() {
        return hostErrorMessage;
    }

    public void setHostErrorMessage(String hostErrorMessage) {
        this.hostErrorMessage = hostErrorMessage;
    }

    public int getTurnPageTotalNum() {
        return turnPageTotalNum;
    }

    public void setTurnPageTotalNum(int turnPageTotalNum) {
        this.turnPageTotalNum = turnPageTotalNum;
    }

    public com.entity.RepParam getRepParam() {
        return RepParam;
    }

    public void setRepParam(com.entity.RepParam repParam) {
        RepParam = repParam;
    }
}
