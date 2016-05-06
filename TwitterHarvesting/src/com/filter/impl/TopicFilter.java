package com.filter.impl;

import com.filter.Filter;

public class TopicFilter implements Filter {

    @Override
    public boolean isFilter(String con, String rules) {
        String[] rs = rules.split(" ");
        if (con.contains(rs[0]) && con.contains(rs[1]))
            return true;
        return false;
    }

}
