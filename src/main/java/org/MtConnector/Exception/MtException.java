package org.MtConnector.Exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by mk on 16/3/14.
 * 继承自 RuntimeException 基本的异常类
 * 支持嵌套 改写了 printStackTrace() 方法
 */
public class MtException extends RuntimeException
{
    private Throwable cause;

    public MtException(String msg)
    {
        super(msg);
    }

    public MtException(String msg,Throwable ex)
    {
        super(msg);
        cause=ex;
    }

    @Override
    public Throwable getCause()
    {
        if (cause == null)
        {
              return null;
        }
        else
        {
            return cause;
        }
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
        return message;
    }

    /**
     * 回溯到最开始的异常
     */
    @Override
    public void printStackTrace(PrintStream ps)
    {
        if (getCause() == null)
        {
            super.printStackTrace(ps);
        }
        else
        {
            getCause().printStackTrace(ps);
        }
    }

    @Override
    public void printStackTrace(PrintWriter pw)
    {
        if (getCause() == null)
        {
            super.printStackTrace(pw);
        }
        else
        {
            getCause().printStackTrace(pw);
        }
    }

    @Override
    public void printStackTrace()
    {
        printStackTrace(System.err);
    }
}






