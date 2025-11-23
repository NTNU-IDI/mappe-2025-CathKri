package edu.ntnu.idi.idatt;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.logging.*;

public class StdoutConsoleHandler extends StreamHandler {

  public StdoutConsoleHandler() {
    super();
    // Write logs to System.out instead of System.err
    setOutputStream(System.out);
    setLevel(Level.INFO);
  }

  @Override
  public synchronized void publish(LogRecord record) {
    super.publish(record);
    flush(); // Make sure logs appear immediately
  }
}
