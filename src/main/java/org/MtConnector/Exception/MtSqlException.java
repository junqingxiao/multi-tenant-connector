package org.MtConnector.Exception;

/**
 * Created by mk on 16/3/14.
 * 与Sql相关的异常 由底层JDBC抛出
 */
public class MtSqlException extends MtException
{
    private String sql;

    public MtSqlException(String msg)
    {
        super(msg);
    }

    public MtSqlException(String msg,Throwable e)
    {
        super(msg,e);
    }

    public MtSqlException(String msg,Throwable e,String sql)
    {
        super(msg,e);
        this.sql=sql;
    }

    @Override
    public String getMessage()
    {
        String message=super.getMessage();
        Throwable cause=getCause();
        if (cause != null)
        {
            message=message + ";Nested org.MtConnector.Exception is " + cause;
        }
        if (sql != null)
        {
            message="sql is : "+ sql +message;
        }
        return message;
    }
}
