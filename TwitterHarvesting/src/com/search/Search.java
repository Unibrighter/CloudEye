package com.search;

import java.util.List;

import com.beans.Tweets;

public interface Search {

    public List<Tweets> search(int count, String sinceDate);

    public List<Tweets> search(int count);

    public List<Tweets> search(int count, String sinceDate, String endDate,
            String[] lang);
}
