package com.mechadragonx.adventureoflink;

import java.util.Collection;

public class Link<T> implements LinkList<T>
{
    public LinkNode<T> head;
    public LinkNode<T> tail;
    private int size;
    private LinkNode<T> current;

    public Link()
    {
        head = null;
        tail = null;
        current = null;
    }
    public Link(T value)
    {
        head = new LinkNode<T>(value);
        tail = null;
        head.next = tail;
        current = head;
    }
    public Link(Collection<T> collection)
    {
        head = null;
        tail = null;
        current = null;
        add(collection);
    }

    public int size() { return size; }
    public boolean isEmpty() { return head == null; }
    public LinkNode<T> next()
    {
        return head.next;
    }
    public LinkNode<T> next(T value) throws NoSuchElementException
    {
        LinkNode<T> current = head;
        while(current != null)
        {
            if(current.value.equals(value))
                return current.next;
            current = current.next;
        }
        throw new NoSuchElementException("\"" + value + "\"" + "was not found!");
    }
    public boolean exists(T value)
    {
        LinkNode<T> current = head;
        while(current != null)
        {
            if(current.value.equals(value))
                return true;
            current = current.next;
            if(current.equals(head))
                break;
        }
        return false;
    }
    public void add(T value)
    {
        if(head == null)
        {
            head = new LinkNode<T>(value);
            tail = null;
            head.next = tail;
            current = head;
        }
        else
        {
            current.next = new LinkNode<T>(value);
            current = current.next;
            tail = current;
        }
        size++;
    }
    public void add(Collection<T> collection)
    {
        for(T item : collection)
            add(item);
    }
    public LinkNode<T> remove()
    {
        LinkNode<T> previous = head;
        LinkNode<T> current = head.next;
        while(current != null)
        {
            if(current.equals(tail))
            {
                previous.next = null;
                tail = previous;
                tail.next = null;
                break;
            }
            previous = previous.next;
            current = current.next;
        }
        size--;
        return current;
    }
    public LinkNode<T> removeHead()
    {
        LinkNode<T> originalHead = head;
        head = head.next;
        size--;
        return originalHead;
    }
    public LinkNode<T> remove(T value) throws NoSuchElementException
    {
        if(value.equals(tail.value))
            remove();
        else if(value.equals(head.value))
            remove();
        boolean removed = false;
        LinkNode<T> previous = head;
        LinkNode<T> current = head.next;
        LinkNode<T> removedNode = null;
        while(current != null)
        {
            if(current.value.equals(value))
            {
                removedNode = current;
                previous.next = current.next;
                current = current.next;
                if (current.next == null)
                    tail = current;
                removed = true;
                break;
            }
            previous = previous.next;
            current = current.next;
        }
        if(!removed)
            throw new NoSuchElementException("\"" + value + "\"" + "was not found!");
        size--;
        return removedNode;
    }
    @Override
    public String toString()
    {
        LinkNode<T> current = head;
        StringBuilder builder = new StringBuilder();
        while(current != null)
        {
            if(current != tail)
                builder.append(current.value).append(" --> ");
            else
                builder.append(current.value).append(" END");
            current = current.next;
        }
        return builder.toString();
    }
}
