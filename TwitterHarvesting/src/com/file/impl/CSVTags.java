package com.file.impl;

import java.util.List;

import com.beans.JsonTweet;
import com.beans.Tag;
import com.file.CSVWriteLIstener;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class CSVTags implements CSVWriteLIstener<Tag> {

    private List<Tag> list;

    public CSVTags(List<Tag> list) {
        this.list = list;
    }

    @Override
    public String[] getHeader() {
        return null;
    }

    @Override
    public List<Tag> getList() {
        return list;
    }

    @Override
    public String[] getRawData(Object o) {
        Tag t = (Tag) o;
        return new String[] { JsonTweet.build(t).toString() };
    }

}
