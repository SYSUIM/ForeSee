package com.example.rwredis;

/*
实体类Data存放每一条微博博文的检索词、博文ID和排序分数等信息
 */

public class Data {
    private String stock_code;
    private String company_name;
    private String short_name;
    private String industry_name;
    private String industry_code;

    public Data(String stock_code, String company_name, String short_name, String industry_name, String industry_code) {
        this.stock_code = stock_code;
        this.company_name = company_name;
        this.short_name = short_name;
        this.industry_name = industry_name;
        this.industry_code = industry_code;
    }

    public String getIndustry_code() {
        return industry_code;
    }

    public void setIndustry_code(String industry_code) {
        this.industry_code = industry_code;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getIndustry_name() {
        return industry_name;
    }

    public void setIndustry_name(String industry_name) {
        this.industry_name = industry_name;
    }

    public String getStock_code() {
        return stock_code;
    }

    public void setStock_code(String stock_code) {
        this.stock_code = stock_code;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }
}
