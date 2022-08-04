package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];
    private static final String NULL_MARKER = "Null marker";

    @Override
    public void put(K key, V value) {
        key = nullCheck(key);
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i]) || keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    private K nullCheck(K key) {
        if (key == null) {
            key = (K) NULL_MARKER;
        }
        return key;
    }

    @Override
    public V get(K key) {
        key = nullCheck(key);
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        while (keys[count] != null) {
            count++;
        }
        return count;
    }
}
