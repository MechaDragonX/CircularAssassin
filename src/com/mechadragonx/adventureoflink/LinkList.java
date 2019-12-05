package com.mechadragonx.adventureoflink;

import java.util.Collection;

public interface LinkList<T>
{
    int size();
    boolean isEmpty();
    LinkNode<T> next();
    LinkNode<T> next(T value) throws NoSuchElementException;
    boolean exists(T value);
    void add(T value);
    void add(Collection<T> collection);
    LinkNode<T> remove();
    LinkNode<T> removeHead();
    LinkNode<T> remove(T value) throws NoSuchElementException;
}
