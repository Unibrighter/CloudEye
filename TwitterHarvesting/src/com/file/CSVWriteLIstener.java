package com.file;

import java.util.List;

public interface CSVWriteLIstener<T> {

    public String[] getHeader();

    public String[] getRawData(Object t);

    public List<T> getList();
}
