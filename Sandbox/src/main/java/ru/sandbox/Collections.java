package ru.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DBorisov on 07.05.2016.
 */
public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
//        List<String> lang1 = Arrays.asList(langs);

//    List<String> languages = new ArrayList<String>();
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("Python");
//    for (int i = 0; i < languages.size(); i++) {
//      System.out.println("Я хочу выучить " + languages.get(i));
//    }
//    for (String l :lang1) {
//        System.out.println("Я очень хочу выучить " + l);

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}



