package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Command {
  default void execute() {};
  default void execute(ObjectInputStream in, ObjectOutputStream out) {}
}
