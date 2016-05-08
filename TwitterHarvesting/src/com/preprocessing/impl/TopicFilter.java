package com.preprocessing.impl;

import com.preprocessing.Filter;

public class TopicFilter implements Filter {

    @Override
    public boolean isFilter(String con, String rules) {
        String[] rs = rules.split(" ");
        if (con.contains(rs[0]) && con.contains(rs[1]))
            return true;
        return false;
    }

}
