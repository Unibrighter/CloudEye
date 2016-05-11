package com.file.impl;

import java.util.List;

import com.beans.Tweet;
import com.file.CSVWriteLIstener;
import com.file.FileUtils;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class CSVTweets implements CSVWriteLIstener<Tweet> {

    private List<Tweet> list;

    public CSVTweets(List<Tweet> list) {
        this.list = list;
    }

    @Override
    public String[] getHeader() {
        return new String[] { FileUtils.HEADER, "content", "JSON" };
    }

    @Override
    public List<Tweet> getList() {
        return list;
    }

    @Override
    public String[] getRawData(Object o) {
        Tweet t = (Tweet) o;
        return new String[] { String.valueOf(t.getId()), t.getContent(),
                t.getJson() };
    }

}
