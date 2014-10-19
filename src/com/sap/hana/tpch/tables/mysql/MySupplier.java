package com.sap.hana.tpch.tables.mysql;

import com.sap.hana.tpch.tables.base.BTSupplier;
import com.sap.hana.tpch.types.ScaleFactor;

/**
 * Created by Alex on 22/09/2014.
 */
public class MySupplier extends MyTable {

    BTSupplier supplier;

    public MySupplier(ScaleFactor scaleFactor) {
        super(scaleFactor);
        supplier = new BTSupplier();
    }

    @Override
    public int getBaseRowsNumber() {
        return supplier.getBaseRowsNumber();
    }

    @Override
    String getBaseCreationScript() {
        String baseScript = "(s_suppkey %s,s_name VARCHAR(25),s_address VARCHAR(40),s_nationkey SMALLINT,s_phone VARCHAR(15),s_acctbal NUMERIC(12, 2),s_comment VARCHAR(101),PRIMARY KEY (s_suppkey))";
        return String.format(baseScript, getSuppKeyType());
    }

    protected String getSuppKeyType(){
        return MyCreatingScriptsService.getKeyFieldType(getScaleFactor(), getBaseRowsNumber());
    }
}
