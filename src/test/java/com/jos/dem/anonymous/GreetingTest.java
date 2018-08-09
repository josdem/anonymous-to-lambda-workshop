package com.jos.dem.anonymous;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class GreetingTest {

  private GreetingService greetingService = new HelloWorld();

  @Test
  @DisplayName("Should show get message as anonymous class")
  void shouldGetMessageWithAnonymous() {
    final String message = greetingService.call(new Greeting() {
      @Override
      public String hello() {
        return "Hello World!";
      }
    });

    assertEquals("Hello World!", message);
  }

  @Test
  @DisplayName("Should remove method name")
  void shouldGetMessageWithoutMethodName() {
    final String message = greetingService.call(() -> {
        return "Hello World!";
    });

    assertEquals("Hello World!", message);
  }

  @Test
  @DisplayName("Should remove return statement")
  void shouldGetMessageWithoutMethodName() {
    final String message = greetingService.call(() -> "Hello World!");
    assertEquals("Hello World!", message);
  }



}
