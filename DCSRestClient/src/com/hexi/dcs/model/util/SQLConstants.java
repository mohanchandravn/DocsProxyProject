package com.hexi.dcs.model.util;

public class SQLConstants {
    public static final String SQL_GET_DCS_PROPERTIES =
            "SELECT RULE_KEY, RULE_TYPE, RULE_VALUE FROM RULE_CONFIGURATION WHERE RULE_TYPE = 'DCS'";
}
