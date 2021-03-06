package ru.otus;

import java.lang.instrument.Instrumentation;

public class Agent {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instrumentation) {
        Agent.instrumentation = instrumentation;
    }

    public static long getSize(Object obj) {
        if (instrumentation == null) {
            throw new IllegalStateException("Agent not initialised");
        }
        return instrumentation.getObjectSize(obj);
    }
}