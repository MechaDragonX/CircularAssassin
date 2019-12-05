package com.mechadragonx.adventureoflink;

public class LinkNode<T>
{
    public T value;
    public LinkNode<T> next;

    public LinkNode(T value)
    {
        this.value = value;
        this.next = null;
    }
    public LinkNode(T value, LinkNode<T> next)
    {
        this.value = value;
        this.next = next;
    }
}
