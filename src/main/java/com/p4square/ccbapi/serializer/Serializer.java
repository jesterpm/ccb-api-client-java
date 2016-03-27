package com.p4square.ccbapi.serializer;

/**
 * A Serializer converts an object of type T to a payload suitable for CCB.
 */
public interface Serializer<T> {

    String encode(T obj);

    void encode(T obj, StringBuilder builder);
}
