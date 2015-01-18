package com.excilys.wrapper;

import com.excilys.dto.ComputerDto;

import java.util.List;

/**
 * Created by eron on 17/01/15.
 */
public class PageWrapper {
    private List<ComputerDto> computers;
    private int total;

    public List<ComputerDto> getComputers() {
        return computers;
    }

    public void setComputers(List<ComputerDto> computers) {
        this.computers = computers;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
