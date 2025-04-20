package com.utils;



public enum LocatorType {
    XPATH, CSS, ID;

    public static LocatorType fromString(String type) {
        switch (type.toLowerCase()) {
            case "xpath":
                return XPATH;
            case "css":
                return CSS;
            case "id":
                return ID;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + type);
        }
    }
}