package edu.ntnu.idi.idatt;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CleanFormatter extends Formatter {

  @Override
  public String format(LogRecord record) {
    return record.getMessage() + System.lineSeparator();
  }
}
