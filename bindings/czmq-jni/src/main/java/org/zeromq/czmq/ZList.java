package org.zeromq.czmq;

public class ZList implements AutoCloseable {
    long pointer;

    public ZList() {
        pointer = __init();
    }

    public ZList(long address) {
        pointer = address;
    }

    native static long __init();

    native static void __destroy(long pointer);

    native static long __size(long pointer);

    public long size() {
        return ZList.__size(pointer);
    }

    @Override
    public void close() {
        __destroy(pointer);
        pointer = 0;
    }
}
