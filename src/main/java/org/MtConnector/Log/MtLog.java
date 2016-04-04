package org.MtConnector.Log;

/**
 * Created by mk on 16/3/10.
 * 用来纪录日志 封装 commons-logging 接口
 * 提供 info warn error 3种层次的纪录
 * info--程序运行中出现的信息
 * warn--可能有危险的警告信息
 * error--发生错误,必须马上终止程序
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MtLog
{
    private static Log log= LogFactory.getLog(MtLog.class);

    public final void info(String message)
    {
        log.info(message);
    }

    public final void warn(String message)
    {
        log.warn(message);
    }

    public final void error(String message)
    {
        log.error(message);
    }
}
