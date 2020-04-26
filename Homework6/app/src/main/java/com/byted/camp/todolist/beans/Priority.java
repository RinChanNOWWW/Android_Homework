package com.byted.camp.todolist.beans;

import android.graphics.Color;

public enum Priority {
    LOW(0), MEDIUM(1), HIGH(2);

    public final int intValue;

    Priority(int intValue) {
        this.intValue = intValue;
    }

    public static Priority from(int intValue) {
        for (Priority priority : Priority.values()) {
            if (priority.intValue == intValue) {
                return priority;
            }
        }
        return LOW; // default
    }

    public static int color(Priority priority) {
        switch (priority) {
            case HIGH:
                return Color.RED;
            case MEDIUM:
                return Color.GREEN;
            default:
                return Color.WHITE;
        }
    }
}
