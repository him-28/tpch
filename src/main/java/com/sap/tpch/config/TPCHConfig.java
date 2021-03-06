package com.sap.tpch.config;

import com.sap.tpch.db_interaction.DBType;

/**
 * Created by Alex on 18.09.2014.
 * Application configuration params.
 */
public class TPCHConfig {

    //Project directory
    public static String PROJECT_DIR = System.getProperty("user.dir");

    //Configuration file name.
    public static String CONFIG_FILE_NAME = TPCHConfig.PROJECT_DIR+"/tpch.properties";

    //SSH connection settings.
    public static String SSH_USER = ConfigImporter.getStringValue("SSH_USER");
    public static String SSH_PWD = ConfigImporter.getStringValue("SSH_PWD");
    public static String HOST = ConfigImporter.getStringValue("HOST");
    public static int SSH_PORT = ConfigImporter.getIntValue("SSH_PORT");

    //TPCH test params
    //Indicate to generate data with random params if 0 or validation params if 1
    public static Integer VALIDATION_QUERY = ConfigImporter.getIntValue("VALIDATION_QUERY") > 0 ? 1 : 0;

    // Network Proxy - replace with your own network proxy or set the HAS_PROXY as false if you don't need to use proxy
    public static final boolean HAS_PROXY = ConfigImporter.getBooleanValue("HAS_PROXY");
    public static final String PROXY_HOST = ConfigImporter.getStringValue("PROXY_HOST");
    public static final int PROXY_PORT = ConfigImporter.getIntValue("PROXY_PORT");

    //Using database settings
    public static DBType DATABASE_TYPE = DBType.HDB;

    // HDB Connection Settings
    //JDBC connection url is "jdbc:sap://<host-id>:3 <instance no>15/?autocommit=false"
    //Assume that HANA Host ID is iltlvl167 and instance no is 00 then JDBC URL will be "jdbc:sap://iltlvl167:30015/?autocommit=false"
    public static final String HDB_URL = String.format("jdbc:sap://%s:%d/?autocommit=false",HOST,ConfigImporter.getIntValue("HDB_PORT"));
    public static final String TPCH_USER = ConfigImporter.getStringValue("TPCH_USER");
    public static final String TPCH_PWD = ConfigImporter.getStringValue("TPCH_PWD");
    public static final String ADM_USER = ConfigImporter.getStringValue("ADM_USER");
    public static final String ADM_PWD = ConfigImporter.getStringValue("ADM_PWD");

    //Default HANA schema name
    public static String SCHEMA_NAME = TPCH_USER;

    //Client deploy params
    //client directory where file for deploying keeping
    public static String CLIENT_DEPLOY_DIR = PROJECT_DIR+"/deploy";
    //Archive file containing necessary files.
    public static String CLIENT_DEPLOY_ARCHIVE = CLIENT_DEPLOY_DIR+"/deploy.zip";
    //File containing code how to expand data.
    public static String CLIENT_DEPLOY_COMMAND = CLIENT_DEPLOY_DIR + "/deploy.sh";

    //Server deploy params
    //Directory on server which contain working files.
    public static String SERVER_WORK_DIR = "/hdb/tpch";
    //Directory on server where test scripts being kept.
    public static String SERVER_TEST_DIR = SERVER_WORK_DIR + "/tests";
    //Directory on server where dbgen program being kept.
    public static String SERVER_DBGEN_DIR = SERVER_WORK_DIR +"/dbgen";

    //Command file to check if table to export exist or not.
    public static String CHECK_TABLE_EXISTENCE = SERVER_TEST_DIR + "/dbgen_check.sh "+SERVER_DBGEN_DIR;
    //get available disk size command.
    public static String CM_DISK_SIZE = "df \"%s\" | sed -n '2p' | awk -F \" \" '{print $4;}'";
    //check is directory exist: 1-yes, 0-no.
    public static String CM_CHECK_IS_DIR = "[ -d \"%s\" ] && echo 1 || echo 0";
    //check is file exist: 1-yes, 0-no.
    public static String CM_CHECK_IS_FILE = "[ -f \"%s\" ] && echo 1 || echo 0";
    //create nested directories.
    public static String CM_MK_DIR = "mkdir -p \"%s\"";
    //set rights to execute script.
    public static String CM_SET_EXEC_WRITES = "chmod 755 \"%s\"";
    //set rights 777
    public static String CM_SET_ALL_WRITES = "sudo chmod 777 \"%s\"";
    //generate data for tables using dbgen.
    public static String CM_DATA_GENERATOR = "cd "+SERVER_DBGEN_DIR+" && ./dbgen -vf -s %s";
    //generate data for table using in refresh function using dbgen.
    public static String CM_DATA_REFRESH_GENERATOR = "cd "+SERVER_DBGEN_DIR+" && ./dbgen -v -S %d -U %d -s %d";
    //get cpu count command.
    public static String CM_GET_CPU_COUNT = "grep --count processor /proc/cpuinfo";
    //get file content.
    public static String CM_READ_FILE_CONTENT = "cat %s";
    //clear dbgen refresh data
    public static String CM_CLEAR_DBGEN_REFRESH_DATA = "rm -f "+SERVER_DBGEN_DIR+"/delete.* "+SERVER_DBGEN_DIR+"/*.tbl.u*";

    public final static boolean DEBUG = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().contains("jdwp");
}
