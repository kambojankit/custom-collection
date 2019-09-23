package com.techarha.java.collections.map;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public interface CustomMap<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean containsKey(K key);
    Set<CustomEntry<K, V>> entrySet();
    Set<K> keySet();
    boolean isEmpty();
    int size();
    List<V> values();
    void remove(K key);

    class CustomEntry<K, V>{
        K key;
        V value;

        public CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public CustomEntry() {
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CustomEntry)) return false;
            CustomEntry<?, ?> that = (CustomEntry<?, ?>) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
