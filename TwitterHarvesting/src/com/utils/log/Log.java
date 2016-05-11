package com.utils.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.file.FileUtils;

import twitter4j.Logger;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public final class Log {

    private static Log logInstance = null;
    private static SimpleDateFormat formatter = new SimpleDateFormat(
            "hh:mm:ss");
    private static Logger log = Logger.getLogger(Log.class);
    private static final String OUTPUT_FORMAT = "%s [%s] %s %s%n";
    private LogType type;

    public Log() {
        this.type = LogType.SYSTEM_OUT;
    }

    public synchronized static Log getInstance() {
        if (logInstance == null) {
            logInstance = new Log();
        }
        return logInstance;
    }

    public void info(String msg) {
        output(msg, LogOption.INFO);
    }

    public void error(String msg) {
        output(msg, LogOption.ERROR);
    }

    public void warn(String msg) {
        output(msg, LogOption.WARN);
    }

    public void fatal(String msg) {
        output(msg, LogOption.FATAL);
    }

    public void debug(String msg) {
        output(msg, LogOption.DEBUG);
    }

    private void output(String msg, LogOption op) {
        String output = format(msg, op);
        switch (type) {
            case SYSTEM_OUT:
                System.out.print(output);
                break;
            case LOG_OUT:
                // TODO import log4J lib.
                switch (op) {
                    case WARN:
                        log.warn(output);
                        break;
                    case ERROR:
                        log.error(output);
                        break;
                    case DEBUG:
                        log.debug(output);
                        break;
                    case INFO:
                        log.info(output);
                        break;
                    case FATAL:
                        // the log instance of the twitter4j does not have the
                        // Fatal method, so here use error method instead of
                        // using fatal one.
                        log.error(output);
                        break;
                }
                break;
            case FILE_OUT:
                FileUtils.getInstance().write(output, FileUtils.FILE_LOG_PATH);
                break;
            case NON_DEBUG:
                // do nothing.
                break;
        }
    }

    private String format(String msg, LogOption op) {
        return String.format(OUTPUT_FORMAT, formatter.format(new Date()),
                Thread.currentThread().getName(), op.name(), msg);
    }

}
