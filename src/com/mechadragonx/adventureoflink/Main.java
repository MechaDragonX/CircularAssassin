package com.mechadragonx.adventureoflink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        execute();
    }
    private static Path getPath() throws IOException
    {
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(stream);
        System.out.println("Please type the path to the file to use: ");
        Path path;
        while(true)
        {
            path = Paths.get(buffer.readLine());
            if(!path.toFile().exists())
                System.out.println("The specified path doesn't point to a file!");
            else if(!isTextFile(path))
                System.out.println("The specified path doesn't point to a text file!");
            else
                return path;
        }
    }
    private static boolean isTextFile(Path path)
    {
        return path.toString().substring(path.toString().length() - 3).equals("txt");
    }
    private static ArrayList<String> readNames(Path path) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
        ArrayList<String> people = new ArrayList<>();
        String name;
        while((name = br.readLine()) != null)
            people.add(name);
        Collections.shuffle(people);
        return people;
    }
    private static void execute() throws Exception
    {
        // DeathCircle circle = new DeathCircle(readNames(Paths.get("./data/names.txt")));
        DeathCircle circle = new DeathCircle(readNames(getPath()));
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(stream);
        System.out.println("Welcome to the Assassin game!");
        System.out.println("Please type a command!");
        commands();
        String[] command;
        while(true)
        {
            command = buffer.readLine().split("\\s");
            if(command.length > 2)
                System.out.println("The command is illegal!");
            else
            {
                switch(command[0].toLowerCase())
                {
                    case "status":
                        circle.status();
                        break;
                    case "alive":
                        circle.alivePlayers();
                        break;
                    case "graveyard":
                        circle.graveyard();
                        break;
                    case "kill":
                        try
                        {
                            circle.kill(command[1]);
                        }
                        catch(NoSuchElementException e)
                        {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "help":
                        commands();
                        break;
                    case "exit":
                        System.out.println("Thanks for playing!");
                        return;
                    default:
                        System.out.println("The command is illegal!");
                        break;
                }
            }
        }
    }
    private static void commands()
    {
        System.out.println("\"status\": Lists the number of alive and dead players in the current round.");
        System.out.println("\"alive\": List the names of people who are still alive.");
        System.out.println("\"graveyard: Lists the names of people who are dead int eh order they died.");
        System.out.println("\"kill <name>\": Kills the specified person.");
        System.out.println("\"help\": Lists the commands");
        System.out.println("\"exit\": Ends the applications");
    }
}
