package com;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.oath.OAthConfig;
import com.resource.GeoType;
import com.resource.Resource;
import com.tasks.RestRequestTask;
import com.tasks.StreamingTask;
import com.utils.log.Log;

public class MainDriver {

    private static final Log log = Log.getInstance();
    private static Options options;

    static {
        options = new Options();
        options.addOption("ap", true, "application number, range from 1 to 8");
    }

    public static void main(String[] args) {
        init(args);
        searchTweets(OAthConfig.getGeoType());
    }

    public static void init(String[] args) {
        log.info("reading command line options");
        CommandLine cmd = null;
        try {
            cmd = new DefaultParser().parse(options, args);
        }
        catch (ParseException e) {
            log.error("CommandLine parser exception, stop system.");
            System.exit(-1);
        }
        
        int applicationNum = 0;
        if (cmd.hasOption("ap")) {
            try {
                applicationNum = Integer.parseInt(cmd.getOptionValue("ap"));
            }
            catch (NumberFormatException e) {
                log.error("-ap requires an application number, parsed: "
                        + cmd.getOptionValue("ap"));
                System.exit(-1);
            }
        }
        
        if (applicationNum >= 1 && applicationNum <= 8) {
            // choose one of the OAthInfo for initializing the system.
            OAthConfig.setApplicationNum(applicationNum);
        }
        else {
            log.error(
                    "application number is the range from 1 to 8, e.g. -ap 1");
            System.exit(-1);
        }
    }

    public static void searchTweets(GeoType geoType) {
        switch (geoType) {
            case Inner_Rct:
            case East_Rct:
            case West_Rct:
            case North_Rct:
                log.info("Streaming task start for: " + geoType);
                new StreamingTask(Resource.getGeoResource());
                break;
            case Inner_Cir:
            case East_Cir:
            case West_Cir:
            case North_Cir:
                log.info("Rest API task start for: " + geoType);
                new RestRequestTask(Resource.getGeoResource());
                break;
        }
    }
}
