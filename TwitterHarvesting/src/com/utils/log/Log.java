package com.utils.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Log {

    private static Log logInstance = null;
    private static SimpleDateFormat formatter = new SimpleDateFormat(
            "HH:mm:ss.SSS");
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
                break;
            case FILE_OUT:
                FileUtils.getInstance().write(output, FileUtils.OUTPUT_PATH);
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
