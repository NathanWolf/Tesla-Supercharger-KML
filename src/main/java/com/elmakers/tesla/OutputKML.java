package com.elmakers.tesla;

import com.elmakers.tesla.parse.Output;
import com.elmakers.tesla.parse.Parser;

public class OutputKML implements Output {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: OutputKML <output file>");
            System.exit(1);
        }

        OutputKML output = new OutputKML();
        output.start();
    }

    private void start() {
        Parser parser = new Parser();
        parser.setOutput(this);
        parser.setFileLocation("superchargers.kml");
        parser.run();
    }

    public void setProgress(int percent, String message) {
        System.out.println(message + ": " + percent + "%");
    }

}
