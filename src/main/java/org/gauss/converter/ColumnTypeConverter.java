package org.gauss.converter;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ColumnTypeConverter
 * @Description:
 * @Author 安磊
 * @Date 2022/3/16
 * @Version V1.0
 **/
public class ColumnTypeConverter {

    private static final Map<String, String> columnTypeMapping = new HashMap<String, String>() {{
        put("BFILE", "bytea");
        put("BLOB", "bytea");
        put("LONG", "text");
        put("CLOB", "text");
        put("NCLOB", "text");
        put("JSON", "json");
        put("LONG RAW", "bytea");
        put("RAW", "bytea");
        put("BINARY_DOUBLE", "double precision");
        put("BINARY_FLOAT", "real");
        put("FLOAT", "real");
        put("NUMBER", "numeric");
        put("CHAR", "character");
        put("NCHAR", "character");
        put("VARCHAR2", "character varying");
        put("NVARCHAR2", "character varying");
        put("DATE", "timestamp");
        put("INTERVAL DAY TO SECOND", "interval day to second");
        put("INTERVAL YEAR TO MONTH", "interval year to month");
        put("TIMESTAMP", "timestamp");
        put("TIMESTAMP WITH TIME ZONE", "timestamp with time zone");
        put("TIMESTAMP WITH LOCAL TIME ZONE", "timestamp with time zone");
        put("XMLTYPE", "xml");
        put("SDO_GEOMETRY","json");
        put("URITYPE","json");
        put("HTTPURITYPE","json");
        put("XDBURITYPE","json");
        put("SDO_TOPO_GEOMETRY","json");
        put("OBJECT","json");
        put("ARRAYS","json");
    }};
    
    private static final Map<String,String> columnTypeMappingWithGeo = new HashMap<String, String>() {{
        put("BFILE", "bytea");
        put("BLOB", "bytea");
        put("LONG", "text");
        put("CLOB", "text");
        put("NCLOB", "text");
        put("JSON", "json");
        put("LONG RAW", "bytea");
        put("RAW", "bytea");
        put("BINARY_DOUBLE", "double precision");
        put("BINARY_FLOAT", "real");
        put("FLOAT", "real");
        put("NUMBER", "numeric");
        put("CHAR", "character");
        put("NCHAR", "character");
        put("VARCHAR2", "character varying");
        put("NVARCHAR2", "character varying");
        put("DATE", "timestamp");
        put("INTERVAL DAY TO SECOND", "interval day to second");
        put("INTERVAL YEAR TO MONTH", "interval year to month");
        put("TIMESTAMP", "timestamp");
        put("TIMESTAMP WITH TIME ZONE", "timestamp with time zone");
        put("TIMESTAMP WITH LOCAL TIME ZONE", "timestamp with time zone");
        put("XMLTYPE", "xml");
        put("SDO_GEOMETRY","geometry");
        put("URITYPE","json");
        put("HTTPURITYPE","json");
        put("XDBURITYPE","json");
        put("SDO_TOPO_GEOMETRY","json");
        put("OBJECT","json");
        put("ARRAYS","json");
    }};  
    /**
     * get columnType for openGauss database
     *
     * @param typeName
     * @return the convert type name
     */
    public String convertTypeName(String typeName) {
        checker checker = new checker();
        if (checker.postgis_check()) {
            return columnTypeMappingWithGeo.getOrDefault(typeName, "character varying");
        }
        return columnTypeMapping.getOrDefault(typeName, "character varying");
    }  
}
