package com.mechadragonx.adventureoflink;

import java.util.ArrayList;
import java.util.TreeMap;

public class DeathCircle
{
    private Link<String> alive;
    private int round;
    private TreeMap<String, Integer> dead;

    public DeathCircle(ArrayList<String> people)
    {
        prepare(people);
        dead = new TreeMap<>();
        status();
    }

    private void prepare(ArrayList<String> people)
    {
        alive = new Link<>(people);
        alive.tail.next = alive.head;
        round = 1;
    }
    public void status()
    {
        System.out.println("===== Round " + round + " =====");
        System.out.println("Remaining Players: " + alive.size());
        if(dead == null)
            System.out.println("Dead Players: " + 0 + "\n");
        else
            System.out.println("Dead Players: " + dead.size() + "\n");
    }
    public void alivePlayers()
    {
        System.out.println("===== Remaining Players =====");
        LinkNode<String> current = alive.head;
        while(true)
        {
            System.out.println(current.value);
            current = current.next;
            if(current == alive.head)
                break;
        }
        System.out.println();
    }
    public void graveyard()
    {
        System.out.println("===== Graveyard =====");
        for(String name : dead.keySet())
        {
            System.out.println(name + ": Died on Round " + dead.get(name));
        }
        System.out.println();
    }
    public void kill(String name) throws NoSuchElementException
    {
        if(!alive.exists(name))
            throw new NoSuchElementException("\"" + name + "\"" + "was not found!");
        if(name.equals(alive.tail.value))
            dead.put(alive.remove().value, round);
        else if(name.equals(alive.head.value))
            dead.put(alive.removeHead().value, round);
        else dead.put(alive.remove(name).value, round);
        if(!alive.isEmpty())
        {
            round++;
            alive.tail.next = alive.head;
        }
        else if(alive.head.next.value.equals(alive.tail.value))
        {
            round++;
            System.out.println(alive.head.value + " is the last one standing! Congratulations " + alive.head.value + "!");
            // System.exit(0);
        }
    }
}
