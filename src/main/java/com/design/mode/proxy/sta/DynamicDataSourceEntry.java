package com.design.mode.proxy.sta;

/**
 * 动态数据源
 */
public class DynamicDataSourceEntry {
    public final static String DEFAULT_SOURCE = null;

    public final static ThreadLocal<String> local = new ThreadLocal<>();


    private DynamicDataSourceEntry(){}

    /**
     * 清空数据源
     */
    public static void clear(){
       local.remove();
    }


    /**
     * 获取当前正在使用的数据源名字
     * @return
     */
    public static String get(){
        return local.get();
    }

    /**
     * 还原当前切面的数据源
     */
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    /**
     * 设置已知名字的数据源
     */
    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_" + year);
    }





}
