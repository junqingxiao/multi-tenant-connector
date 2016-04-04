package org.MtConnector.Exception;

/**
 * Created by mk on 16/3/14
 * 错误的配置文件 参数个数不对或者参数非法
 */
public class IllegalCfgFileException extends MtException
{
    public IllegalCfgFileException(String msg)
    {
        super(msg);
    }

    public IllegalCfgFileException(String msg, Throwable e)
    {
        super(msg,e);
    }
}
