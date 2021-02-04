package com.kglab.lmcp.util;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO  包装类$
 *
 * @author sc
 * @date 2021/1/15
 */
public abstract class PackageIn<T> {


    public ArrayList<T> toList(){
        ArrayList<T> l =  new ArrayList<T>();
        l.add((T) this);
        return l;
    }

}
