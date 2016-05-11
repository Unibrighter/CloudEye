package com.file;

import java.util.List;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public interface CSVWriteLIstener<T> {

    public String[] getHeader();

    public String[] getRawData(Object t);

    public List<T> getList();
}
