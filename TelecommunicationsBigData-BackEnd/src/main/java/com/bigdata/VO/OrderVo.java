package com.bigdata.VO;

import lombok.Data;
import lombok.Setter;

import java.util.List;


public class OrderVo {
    List<Long> ids;
    List<Long>  totalAmounts;
    public void setTotalAmounts(List<Long> totalAmounts) {
        this.totalAmounts = totalAmounts;
    }
    public List<Long> getTotalAmounts() {
        return totalAmounts;
    }

    public List<Long> getIds() {
        return ids;
    }
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
