package org.MtConnector.Session;

import org.MtConnector.Configuration.MtConfiguration;
import org.MtConnector.Exception.IllegalCfgFileException;
import org.MtConnector.Exception.MtException;
import org.MtConnector.Exception.MtSqlException;
import org.MtConnector.Log.MtLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by mk on 16/3/14.
 * 一次数据库的连接 用一个session
 */
public class MtSession
{
    private String url;
    private String multiMode;
    private String driverName;

    private String tenantIdentifier;

    private Connection conn=null;
    private MtLog logger=new MtLog();

    public MtSession(MtConfiguration cfg,String tenantIdentifier)
    {
        this.url=cfg.getUrl();
        this.multiMode=cfg.getMultiMode();
        this.driverName=cfg.getDriverName();
        this.tenantIdentifier=tenantIdentifier;

        try
        {
            Class.forName(this.driverName);
        }
        catch (ClassNotFoundException e)
        {
            logger.error("Illegal DriverName");
            throw new IllegalCfgFileException("Illegal DriverName",e);
        }
        try
        {
            conn=DriverManager.getConnection(this.url);
            logger.info("got connection");
        }
        catch (SQLException e)
        {
            logger.error("Could not get connection");
            throw new MtSqlException("Could not get connection",e);
        }
        /**
         * 根据不同的multiMode决定预处理
         * 剩下两种暂时没有实现
         */
        if (this.multiMode.equals("SCHEMA"))
        {
            try
            {
                Statement stmt = conn.createStatement();
                stmt.execute("USE "+this.tenantIdentifier);
                logger.info("used tenantIdentifier :"+tenantIdentifier);
            }
            catch (SQLException e)
            {
                logger.error("Could not use the tenantIdentifier");
                throw new MtSqlException("Could not use the tenantIdentifier",e,"USE");
            }
        }
    }

    /**
     * 封装的 JDBC 的 int executeUpdate(String sql)
     * 执行一段sql
     * @return 返回受影响的行数
     */
    public int executeUpdate(String sql)
    {
        int rows;
        try
        {
            Statement stmt=conn.createStatement();
            rows=stmt.executeUpdate(sql);
            logger.info("Update executed.");
        }
        catch (SQLException e)
        {
            logger.error("Could not execute Update");
            throw new MtSqlException("Could not execute Update",e);
        }
        return rows;
    }

    /**
     * 封装的 JDBC 的 ResultSet executeQuery(String sql)
     * 执行一段query sql
     * @return 返回查询到的数据
     */
    public MtResultSet executeQuery(String sql)
    {
        MtResultSet set;
        try
        {
            Statement stmt=conn.createStatement();
            set=new MtResultSet(stmt.executeQuery(sql));
            logger.info("Query executed.");
        }
        catch (SQLException e)
        {
            logger.error("Could not execute Query");
            throw new MtSqlException("Could not execute Query",e,"select");
        }
        return set;
    }

    public void close()
    {
        if (conn != null)
        {
            try
            {
                conn.close();
                conn=null;
            }
            catch (SQLException e)
            {
                logger.error("Could not close connection");
                throw new MtSqlException("Could not close connection",e);
            }
        }
    }

    @Override
    protected void finalize()
    {
        if (conn != null)
        {
            try
            {
                conn.close();
                conn=null;
                super.finalize();
            }
            catch (SQLException e)
            {
                logger.error("Could not close connection");
                throw new MtSqlException("Could not close connection",e);
            }
            catch (Throwable t)
            {
                logger.error("Could not close connection");
                throw new MtException("Could not close connection",t);
            }
        }
    }
}








