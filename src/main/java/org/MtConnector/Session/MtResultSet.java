package org.MtConnector.Session;


import org.MtConnector.Exception.MtSqlException;
import org.MtConnector.Log.MtLog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mk on 16/3/16.
 * query返回的数据 封装 JDBC 的ResultSet
 */

public class MtResultSet
{
    private ResultSet set;
    private MtLog logger;

    public MtResultSet(ResultSet set)
    {
        this.set=set;
        this.logger=new MtLog();
    }

    /**
     * 移到下一行
     * @return 是否成功
     */
    public boolean next()
    {
        boolean returnValue;

        try
        {
            returnValue=this.set.next();
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.next()");
            throw new MtSqlException("Error occurred in MtResultSet.next()",e);
        }
        return returnValue;
    }

    /**
     * 由 columnIndex
     * @return 得到String
     */
    public String getString(int columnIndex)
    {
        String returnString;

        try
        {
            returnString=this.set.getString(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getString(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getString(int columnIndex)",e);
        }
        return returnString;
    }

    /**
     * 由 columnIndex
     * @return 得到boolean
     */
    public boolean getBoolean(int columnIndex)
    {
        Boolean returnBoolean;

        try
        {
            returnBoolean=this.set.getBoolean(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getBoolean(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getBoolean(int columnIndex)",e);
        }
        return returnBoolean;
    }

    /**
     * 由 columnIndex
     * @return 得到byte
     */
    public byte getByte(int columnIndex)
    {
        byte returnByte;

        try
        {
            returnByte=this.set.getByte(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getByte(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getByte(int columnIndex)",e);
        }
        return returnByte;
    }

    /**
     * 由 columnIndex
     * @return 得到short
     */
    public short getShort(int columnIndex)
    {
        short returnShort;

        try
        {
            returnShort=this.set.getShort(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getShort(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getShort(int columnIndex)",e);
        }
        return returnShort;
    }

    /**
     * 由 columnIndex
     * @return 得到int
     */
    public int getInt(int columnIndex)
    {
        int returnInt;

        try
        {
            returnInt=this.set.getInt(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getInt(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getInt(int columnIndex)",e);
        }
        return returnInt;
    }

    /**
     * 由 columnIndex
     * @return 得到long
     */
    public long getLong(int columnIndex)
    {
        long returnLong;

        try
        {
            returnLong=this.set.getLong(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getLong(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getLong(int columnIndex)",e);
        }
        return returnLong;
    }

    /**
     * 由 columnIndex
     * @return 得到float
     */
    public float getFloat(int columnIndex)
    {
        float returnFloat;

        try
        {
            returnFloat=this.set.getFloat(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getFloat(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getFloat(int columnIndex)",e);
        }
        return returnFloat;
    }

    /**
     * 由 columnIndex
     * @return 得到double
     */
    public double getDouble(int columnIndex)
    {
        double returnDouble;

        try
        {
            returnDouble=this.set.getDouble(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getDouble(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getDouble(int columnIndex)",e);
        }
        return returnDouble;
    }

    /**
     * 由 columnIndex
     * @return 得到byte[]
     */
    public byte[] getBytes(int columnIndex)
    {
        byte[] returnBytes;

        try
        {
            returnBytes=this.set.getBytes(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getBytes(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getBytes(int columnIndex)",e);
        }
        return returnBytes;
    }

    /**
     * 由 columnIndex
     * @return 得到date
     */
    public java.sql.Date getDate(int columnIndex)
    {
        java.sql.Date returnDate;

        try
        {
            returnDate=this.set.getDate(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getDate(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getDate(int columnIndex)",e);
        }
        return returnDate;
    }

    /**
     * 由 columnIndex
     * @return 得到time
     */
    public java.sql.Time getTime(int columnIndex)
    {
        java.sql.Time returnTime;

        try
        {
            returnTime=this.set.getTime(columnIndex);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getTime(int columnIndex)");
            throw new MtSqlException("Error occurred inMtResultSet.getTime(int columnIndex)",e);
        }
        return returnTime;
    }

    /**
     * 由 columnLabel
     * @return 得到String
     */
    public String getString(String columnLabel)
    {
        String returnString;

        try
        {
            returnString=this.set.getString(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getString(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getString(String columnLabel)",e);
        }
        return returnString;
    }

    /**
     * 由 columnLabel
     * @return 得到boolean
     */
    public boolean getBoolean(String columnLabel)
    {
        Boolean returnBoolean;

        try
        {
            returnBoolean=this.set.getBoolean(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getBoolean(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getBoolean(String columnLabel)",e);
        }
        return returnBoolean;
    }

    /**
     * 由 columnLabel
     * @return 得到byte
     */
    public byte getByte(String columnLabel)
    {
        byte returnByte;

        try
        {
            returnByte=this.set.getByte(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getByte(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getByte(String columnLabel)",e);
        }
        return returnByte;
    }

    /**
     * 由 columnLabel
     * @return 得到short
     */
    public short getShort(String columnLabel)
    {
        short returnShort;

        try
        {
            returnShort=this.set.getShort(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getShort(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getShort(String columnLabel)",e);
        }
        return returnShort;
    }

    /**
     * 由 columnLabel
     * @return 得到int
     */
    public int getInt(String columnLabel)
    {
        int returnInt;

        try
        {
            returnInt=this.set.getInt(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getInt(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getInt(String columnLabel)",e);
        }
        return returnInt;
    }

    /**
     * 由 columnLabel
     * @return 得到long
     */
    public long getLong(String columnLabel)
    {
        long returnLong;

        try
        {
            returnLong=this.set.getLong(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getLong(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getLong(String columnLabel)",e);
        }
        return returnLong;
    }

    /**
     * 由 columnLabel
     * @return 得到float
     */
    public float getFloat(String columnLabel)
    {
        float returnFloat;

        try
        {
            returnFloat=this.set.getFloat(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getFloat(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getFloat(String columnLabel)",e);
        }
        return returnFloat;
    }

    /**
     * 由 columnLabel
     * @return 得到double
     */
    public double getDouble(String columnLabel)
    {
        double returnDouble;

        try
        {
            returnDouble=this.set.getDouble(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getDouble(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getDouble(String columnLabel)",e);
        }
        return returnDouble;
    }

    /**
     * 由 columnLabel
     * @return 得到byte[]
     */
    public byte[] getBytes(String columnLabel)
    {
        byte[] returnBytes;

        try
        {
            returnBytes=this.set.getBytes(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getBytes(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getBytes(String columnLabel)",e);
        }
        return returnBytes;
    }

    /**
     * 由 columnLabel
     * @return 得到date
     */
    public java.sql.Date getDate(String columnLabel)
    {
        java.sql.Date returnDate;

        try
        {
            returnDate=this.set.getDate(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getDate(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getDate(String columnLabel)",e);
        }
        return returnDate;
    }

    /**
     * 由 columnLabel
     * @return 得到time
     */
    public java.sql.Time getTime(String columnLabel)
    {
        java.sql.Time returnTime;

        try
        {
            returnTime=this.set.getTime(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getTime(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getTime(String columnLabel)",e);
        }
        return returnTime;
    }

    /**
     * 由 columnLabel
     * @return 得到timestamp
     */
    public java.sql.Timestamp getTimestamp(String columnLabel)
    {
        java.sql.Timestamp returnTime;

        try
        {
            returnTime=this.set.getTimestamp(columnLabel);
        }
        catch (SQLException e)
        {
            this.logger.error("Error occurred in MtResultSet.getTimestamp(String columnLabel)");
            throw new MtSqlException("Error occurred inMtResultSet.getTimestamp(String columnLabel)",e);
        }
        return returnTime;
    }
}


