package org.MtConnector.Exception;

/**
 * Created by mk on 16/3/14.
 * 找不到 配置文件
 */
public class InvalidCfgPathException extends MtException
{
    private String msg;

    public InvalidCfgPathException(String msg)
    {
        super(msg);
    }

    public InvalidCfgPathException(String msg,Throwable ex)
    {
        super(msg,ex);
    }
}
