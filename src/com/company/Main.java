package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\dench\\Desktop\\Уроки java\\Harry poter.txt")));
        content = content.toLowerCase();
        content = content.replaceAll("[^a-z ]","");
        System.out.println(content);
        String[] array = content.split(" ");
        List<String> list = new ArrayList<>(
                Arrays.asList(array)
        );
        System.out.println(list.size());
        List<String> listUnique = list.stream()
                .distinct().collect(Collectors.toList());//поиск уникальних слов
        System.out.println(listUnique.size());
        Map<String, Integer> glossary = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            if(!glossary.containsKey(key)){
                glossary.put(key,1);
            }else {
                int value = glossary.get(key);
                glossary.put(key,value++);
            }
        }
        for(Map.Entry<String, Integer> entry : glossary.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
