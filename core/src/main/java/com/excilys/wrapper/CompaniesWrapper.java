package com.excilys.wrapper;

import com.excilys.dto.CompanyDto;

import java.util.List;

/**
 * Created by eron on 24/01/15.
 */
public class CompaniesWrapper {
    private List<CompanyDto> companies;
    private int total;

    public List<CompanyDto> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyDto> companies) {
        this.companies = companies;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
