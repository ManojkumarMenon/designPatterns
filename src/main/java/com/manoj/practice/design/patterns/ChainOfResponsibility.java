package com.manoj.practice.design.patterns;

public class ChainOfResponsibility {

    public static void main(String[] args) {

        Logger logger = new Trace();
        logger.printLog(LogLevels.Trace, "Trace Msg");
        logger.printLog(LogLevels.Error, "Error Msg");
        logger.printLog(LogLevels.Info, "Info Msg");
        logger.printLog(LogLevels.Debug, "Debug Msg");

    }

}

interface Logger {
    public void printLog(LogLevels level, String msg);
}

class Trace implements Logger {

    private Logger nextLogger = new Debug();

    public void printLog(LogLevels level, String msg) {
        if (level.equals(LogLevels.Trace))
            System.out.println("Trace Logger :- " + msg);
        else
            nextLogger.printLog(level, msg);

    }

}

class Debug implements Logger {

    private Logger nextLogger = new Info();

    public void printLog(LogLevels level, String msg) {
        if (level.equals(LogLevels.Debug))
            System.out.println("Debug Logger :- " + msg);
        else
            nextLogger.printLog(level, msg);

    }

}

class Info implements Logger {

    private Logger nextLogger = new Error();

    public void printLog(LogLevels level, String msg) {
        if (level.equals(LogLevels.Info))
            System.out.println("Info Logger :- " + msg);
        else
            nextLogger.printLog(level, msg);

    }

}

class Error implements Logger {

    public void printLog(LogLevels level, String msg) {
        if (level.equals(LogLevels.Error))
            System.out.println("Error Logger :- " + msg);
        else
            System.out.println("No logger available");

    }

}

enum LogLevels {
    Trace,
    Debug,
    Info,
    Error
}