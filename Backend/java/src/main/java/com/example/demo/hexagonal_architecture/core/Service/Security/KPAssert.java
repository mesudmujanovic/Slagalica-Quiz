package com.example.demo.hexagonal_architecture.core.Service.Security;

public class KPAssert {

    public static void isNull(Object o, String message) throws KPException {
        if (!o.equals(null)) {
            throw new KPException(message);
        }
    }

    public static void isNotNull(Object o, String message) throws KPException {
        if (o.equals(null)) {
            throw new KPException(message);
        }
    }

    public static void isTrue(Boolean b, String message) throws KPException {
        KPAssert.isNotNull(b, "Object can't be null");
        if (!b) {
            throw new KPException(message);
        }
    }

    public static void isFalse(Boolean b, String message) throws KPException {
        KPAssert.isNotNull(b, "Object can't be null");
        if (b) {
            throw new KPException(message);
        }
    }
}