package org.MtConnector.Configuration;


import org.MtConnector.Log.MtLog;
import org.MtConnector.Exception.*;
import org.MtConnector.Session.MtSession;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mk on 16/3/9.
 * 用来读取xml配置文件
 * 默认为 MtConfiguration.xml
 */
public class MtConfiguration
{
    /**
     * 默认的xml配置文件的路径
     * */
    private String xmlPath="src/main/resources/MtConfiguration.xml";
    /**
     *数据库驱动名字
     */
    private String driverName;
    /**
     * 连接数据库的url
     */
    private String url;
    /**
     * 多租户的方式
     * DATABASE：一个租户一个 database
     * SCHEMA：一个租户一个 Schema
     * DISCRIMINATOR：租户共享数据表
     * 默认为SCHEMA 其它2种暂未实现
     */
    private String multiMode="SCHEMA";

    public String getDriverName() {
        return driverName;
    }

    public String getMultiMode() {
        return multiMode;
    }

    public String getUrl() {
        return url;
    }

    /**
     * 构造函数
     */
    public MtConfiguration(){}

    /**
     * 带自定义的xml文件路径 src开始就可以
     */
    public MtConfiguration(String xmlPath)
    {
        this.xmlPath=xmlPath;
    }
    /**
     * 配置
     */
    public void configure()
    {
        Xml2Map xml2Map=new Xml2Map();
        HashMap map=xml2Map.parserXml(xmlPath);

        if (map.size() != 3)
        {
            new MtLog().error("The cfg file's size is not 3");
            throw new IllegalCfgFileException("The cfg file's size is not 3");
        }
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            assert (key instanceof String):"key类型检查";
            assert (value instanceof String):"value类型检查";

            if (key.toString().equals("driverName"))
            {
                driverName=value.toString();
            }
            else if(key.toString().equals("url"))
            {
                url=value.toString();
            }
            else if(key.toString().equals("multiMode"))
            {
                multiMode=value.toString();
            }
        }
        new MtLog().info("org.MtConnector.Configuration successfully.");
    }

    /**
     * 开启Session
     */
    public MtSession openSessionWithTenantIdentifier(String tenantIdentifier)
    {
        MtSession session=new MtSession(this,tenantIdentifier);

        return session;
    }
}

