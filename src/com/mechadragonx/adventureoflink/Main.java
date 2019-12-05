package com.mechadragonx.adventureoflink;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
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
        String pathString = path.toString();
        for(int i = pathString.length() - 1; i >= pathString.length() - 2; i--)
        {
            if(i == pathString.length() - 1)
            {
                if (pathString.charAt(i) != 't')
                    return false;
            }
            else if(i == pathString.length() - 2)
            {
                if (pathString.charAt(i) != 'x')
                    return false;
            }
            else if(i == pathString.length() - 3)
            {
                if (pathString.charAt(i) != 't')
                    return false;
            }
        }
        return true;
    }
    private static ArrayList<String> readNames(Path path) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
        ArrayList<String> people = new ArrayList<>();
        String name;
        while((name = br.readLine()) != null)
            people.add(name);
        return people;
    }
}
