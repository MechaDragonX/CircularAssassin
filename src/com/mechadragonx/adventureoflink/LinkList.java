package com.mechadragonx.adventureoflink;

import java.util.Collection;

public interface LinkList<T>
{
    LinkNode<T> next();
    LinkNode<T> next(T value) throws NoSuchElementException;
    boolean exists(T value);
    void add(T value);
    void add(Collection<T> collection);
    LinkNode<T> remove();
    LinkNode<T> remove(T value) throws NoSuchElementException;
}
