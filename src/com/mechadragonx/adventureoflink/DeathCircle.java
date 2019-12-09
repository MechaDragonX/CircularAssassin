package com.mechadragonx.adventureoflink;

import java.util.ArrayList;

public class DeathCircle
{
    private Link<String> alive;
    private int round;
    private ArrayList<String> dead;
    private boolean gameOver;

    public DeathCircle(ArrayList<String> people)
    {
        prepare(people);
        dead = new ArrayList<>();
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
        if(alive.size() != 0)
            System.out.println("===== Round " + round + " =====");
        else
            System.out.println("===== Final Status =====");
        if(alive == null)
            System.out.println("Remaining Players: " + 0 + "\n");
        else
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
            if(current != null)
            {
                System.out.println(current.value);
                if(current.next == alive.head)
                    break;
                current = current.next;
            }
            else
                break;
        }
        System.out.println();
    }
    public void graveyard()
    {
        System.out.println("===== Graveyard =====");
        for(int i = 0; i < dead.size(); i++)
        {
            System.out.println("Round " + (i + 1) + ": " + dead.get(i));
        }
        System.out.println();
    }
    public void kill(String name) throws NoSuchElementException
    {
        if(gameOver)
        {
            System.out.println("The game is over!");
            return;
        }

        if(!alive.exists(name))
            throw new NoSuchElementException("\"" + name + "\"" + " was not found! Remember you have to use the same case as the name the file!");
        if(name.equals(alive.tail.value))
            dead.add(alive.remove().value);
        else if(name.equals(alive.head.value))
        {
            dead.add(alive.removeHead().value);
            alive.tail.next = alive.head;
        }
        else
            dead.add(alive.remove(name).value);
        if(alive.size() != 1)
        {
            round++;
            alive.tail.next = alive.head;
            System.out.println(name + " was successfully assassinated!");
        }
        else
        {
            System.out.println(alive.head.value + " is the last one standing! Congratulations " + alive.head.value + "!\n");
            gameOver = true;
        }
    }
}
