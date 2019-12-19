package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Socket pingSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {

            String currentPassword = "ubabrawszy";
            int currentNumber = 5;
            List<String> words = new ArrayList<>();

            Scanner input2 = new Scanner(new File("file.txt"));
            while(input2.hasNextLine())
            {
                String word = input2.nextLine();
                if(word.contains("ia") && word.contains("n") && isAlpha(word)){
                    words.add(word);
                }
            }
            Set<String> sWords = new LinkedHashSet<String>(words);
            List<String> worders = new ArrayList<>(sWords);

            int index = 0;
            while(currentNumber > 0)
            {
                currentPassword = worders.get(index);
                String input = "LOGIN szymon;" + currentPassword;

                pingSocket = new Socket("10.150.2.246", 3002);
                out = new PrintWriter(pingSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));

                out.println(input);
                String output = in.readLine();
                if (!output.equals("false"))
                    currentNumber = Integer.parseInt(output);

                if (currentNumber < 6)
                    System.out.println(currentPassword + " " + currentNumber);

                out.close();
                in.close();
                pingSocket.close();
                index++;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
}
