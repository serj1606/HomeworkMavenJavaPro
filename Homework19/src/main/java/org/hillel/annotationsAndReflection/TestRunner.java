package org.hillel.annotationsAndReflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import org.hillel.annotationsAndReflection.anotation.AfterSuite;
import org.hillel.annotationsAndReflection.anotation.BeforeSuite;
import org.hillel.annotationsAndReflection.anotation.Test;

public class TestRunner {
  public static void start(Class<?> clazz) throws Exception {
    Method[] methods = clazz.getDeclaredMethods();
    ArrayList<Method> beforeSuiteMethods = new ArrayList<>();
    ArrayList<Method> afterSuiteMethods = new ArrayList<>();
    ArrayList<Method> testMethods = new ArrayList<>();

    for (Method method : methods) {
      if (method.isAnnotationPresent(BeforeSuite.class)) {
        beforeSuiteMethods.add(method);
      } else if (method.isAnnotationPresent(Test.class)) {
        testMethods.add(method);
      } else if (method.isAnnotationPresent(AfterSuite.class)) {
        afterSuiteMethods.add(method);
      }
    }

    if (beforeSuiteMethods.size() > 1 || afterSuiteMethods.size() > 1) {
      throw new RuntimeException("BeforeSuite and AfterSuite should be present only once");
    }

    testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

    if (!beforeSuiteMethods.isEmpty()) {
      beforeSuiteMethods.get(0).invoke(null);
    }

    for (Method method : testMethods) {
      method.invoke(null);
    }

    if (!afterSuiteMethods.isEmpty()) {
      afterSuiteMethods.get(0).invoke(null);
    }
  }
}
