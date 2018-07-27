package com.willow.common.constants;


/**
 * @ClassName: BossConstant
 * @Description: boss公用常量
 * @author Eric
 * @date 2015-5-19 上午10:37:05
 */
public interface BossConstant {

    Long ROOT_FUNC = 0l;//菜单根代码
    String FUNC_SECOND_MENU="2";
    String FUNC_THREE_MENU="3";


    /**
     * @Fields DB_TYPE_YES : 数据库中存值为1
     */
    String  DB_TYPE_YES     = "1";

    /**
     * @Fields DB_TYPE_NO : 数据库中存值为0
     */
    String  DB_TYPE_NO     = "0";


    String ROOT_DEPT = "1000";//部门根代码
    public static final String DEFAULT_USER_PWD="123456";
    public static final String DELETE_FLAG_YES= "1";
    public static final String DELETE_FLAG_NO= "2";
    public static final String FIELD_TYPE_DATE="DATE"; //列设置日期类型
    public static final String FIELD_TYPE_VARCHAR2="VARCHAR2";   //字符串
    public static final String FIELD_TYPE_PARAM ="PARAM";     //参数表
    public static final  String FIELD_TYPE_FLOAT ="FLOAT";   // 金额/100
    public static final  String FIELD_TYPE_ENUM ="ENUM";   // 枚举类型

}
