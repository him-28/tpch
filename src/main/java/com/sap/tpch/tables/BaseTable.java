package com.sap.tpch.tables;

import com.sap.tpch.types.ScaleFactor;

/**
 * Created by Alex on 10.10.2014.
 * Contain base for different Databases information about tables.
 */
abstract public class BaseTable implements ITableGenerator{

    /**
     * Scale factor value.
     */
    private ScaleFactor scaleFactor;

    protected BaseTable(){}

    public BaseTable(ScaleFactor scaleFactor){
        this.scaleFactor = scaleFactor;
    }

    /**
     * return scale factor.
     * @return scale factor.
     */
    protected ScaleFactor getScaleFactor(){
        return scaleFactor;
    }

    /**
     * Gen name of file generated by dbgen, containing data.
     * @return name of file generated by dbgen.
     */
    public String getGeneratedTableName(){
        return DBService.getTableName(this.getClass()).toLowerCase()+".tbl";
    }

    /**
     * Get name of file generated by dbgen.
     * Table class name is T(some_table_name). Method get some_table_name in low case and add .tbl extension to end.
     * @return name of table
     */
    public String getTableName(){
        return DBService.getTableName(this.getClass());
    }

}
