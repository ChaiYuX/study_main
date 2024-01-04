package com.entity;

import java.math.BigDecimal;

public class Row {
    private String currencyType;

    private BigDecimal payAmount;

    private BigDecimal recAmount;

    private String transferDate;

    private String transferTime;

    private BigDecimal balance;

    private String vouchersNo;

    private String rem;

    private String summary;

    private String account;

    private String accountName;

    private String transferFlowNo;

    private String accountBankNo;

    private String sysDate;

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(BigDecimal recAmount) {
        this.recAmount = recAmount;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }



    public String getVouchersNo() {
        return vouchersNo;
    }

    public void setVouchersNo(String vouchersNo) {
        this.vouchersNo = vouchersNo;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }



    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTransferFlowNo() {
        return transferFlowNo;
    }

    public void setTransferFlowNo(String transferFlowNo) {
        this.transferFlowNo = transferFlowNo;
    }

    public String getAccountBankNo() {
        return accountBankNo;
    }

    public void setAccountBankNo(String accountBankNo) {
        this.accountBankNo = accountBankNo;
    }


}
