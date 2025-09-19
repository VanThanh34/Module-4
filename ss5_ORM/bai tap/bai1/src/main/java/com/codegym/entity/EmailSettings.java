package com.codegym.entity;


public class EmailSettings {
    private String language;
    private int pageSize;
    private boolean spam;
    private String sign;

    public EmailSettings() {
    }

    public EmailSettings(String language, int page, boolean spam, String sign) {
        this.language = language;
        this.pageSize = page;
        this.spam = spam;
        this.sign = sign;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
