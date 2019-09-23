package com.techarha.java.collections.map;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Objects.isNull;

public class CustomHashtable<K, V> implements CustomMap<K, V> {

    LinkedList<CustomEntry<K, V>>[] storage;
    private int _size = 0;
    private static final int INITIAL_CAPACITY = 10;

    public CustomHashtable() {
        storage = (LinkedList<CustomEntry<K, V>>[]) Array.newInstance(LinkedList.class, INITIAL_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        CustomEntry<K, V> entry = new CustomEntry<>(key, value);

        if(isNull(storage[index]))
            storage[index] = new LinkedList<>();

        storage[index].add(entry);
        _size++;
    }

    @Override
    public V get(K key) {
        if(!containsKey(key)) return null;

        LinkedList<CustomEntry<K, V>> entryList = storage[getIndex(key)];

        CustomEntry<K, V> reducedEntry =  entryList.stream()
            .filter(entry -> entry.getKey().equals(key))
            .findFirst()
            .get();

        return reducedEntry.getValue();
    }

    @Override
    public boolean containsKey(K key) {
        return keySet().contains(key);
    }

    @Override
    public Set<CustomEntry<K, V>> entrySet() {
        Set<CustomEntry<K, V>> set = new HashSet<>();
        for (LinkedList<CustomEntry<K, V>> list : storage) {
           if(!isNull(list)) set.addAll(list);
        }
        return set;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (CustomEntry<K, V> entry : entrySet()) {
            set.add(entry.getKey());
        }
        return set;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public List<V> values() {
        List<V> valuesList = new ArrayList<>();
        for (CustomEntry<K, V> entry : entrySet()) {
            valuesList.add(entry.getValue());
        }
        return valuesList;
    }

    @Override
    public void remove(K key) {
        CustomEntry<K, V> deleteEntry = new CustomEntry<>();
        deleteEntry.setKey(key);

        LinkedList<CustomEntry<K, V>> entryList = storage[getIndex(key)];

        if(!isNull(entryList) && entryList.remove(deleteEntry)) _size--;
    }

    private int getIndex(K key) {
        if(isNull(key)) return storage.length - 1;
        return key.hashCode() % ( storage.length - 1);
    }
}
