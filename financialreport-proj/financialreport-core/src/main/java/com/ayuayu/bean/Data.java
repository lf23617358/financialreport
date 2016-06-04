package com.ayuayu.bean;

import java.util.HashMap;
import java.util.Map;

public class Data {
    private Map<Integer, Number> datas = new HashMap<Integer, Number>();

    /**
     * @param data
     *            the data to set
     */
    public void addData(Integer key, Number data) {
        this.datas.put(key, data);
    }

    /**
     * @return the data
     */
    public Number getData(Integer key) {
        return datas.get(key);
    }

    /**
     * @return the data
     */
    public Map<Integer, Number> getDatas() {
        return datas;
    }

}
