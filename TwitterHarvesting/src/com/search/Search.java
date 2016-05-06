package com.search;

import java.util.List;

import com.config.Tweets;

public interface Search {

    public List<Tweets> search(String[] key);

    public List<Tweets> search(String[] key, int count, String sinceDate);

    public List<Tweets> search(String[] key, int count);

    public List<Tweets> search(String[] key, int count, String sinceDate,
            String endDate, double[][] locations, String[] lang);
}
