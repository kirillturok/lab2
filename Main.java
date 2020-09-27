package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static List[] list = new List[26];

    public static void main(String[] args) throws IOException, ParseException {
        for (int i=0;i<26;i++){
            list[i] = new List();
        }
        file();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("----------\nВведите\n1 - добавление слова\n2 - поиск слова\n3 - удаление слова\n0 - завершить программу");
            int in = scanner.nextInt();
            if (in==1) add();
            if (in==2) src();
            if (in==3) delete();
            if (in==0) System.exit(0);


        }while (true);
    }

    public static void file() throws IOException {
        File file = new File("src/dictionary.txt");
        if (file.exists()) {
            FileReader fw = new FileReader(file);
            Scanner scanner = new Scanner(fw);
            while (scanner.hasNextLine()) {
                hashAdd(scanner.nextLine());
            }
        }
    }

    private static void hashAdd(String word) {
        int key=Character.toUpperCase(word.charAt(0))-'A';
        list[key].add(word);
    }

    private static void add(){
        System.out.println("Введите слово, которое нужно добавить.");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String s = scanner.nextLine();
            if(s.matches("[A-Za-z]+")){
                hashAdd(s);
                return;
            }else{System.out.println("Некорректный ввод. Повторите еще раз.");}
        }

    }

    private static void src(){
        System.out.println("Введите слово.");
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if(s.matches("[A-Za-z]+")){
                int key=Character.toUpperCase(s.charAt(0))-'A';
                if (list[key].size()!=0&&list[key].search(s)){
                    System.out.println("Такое слово есть в словаре");
                }else{
                    System.out.println("Такого слова нет.");
                }
                return;
            }else{System.out.println("Некорректный ввод. Повторите еще раз.");}
        }
    }

    private static void delete(){
        System.out.println("Введите слово, которое нужно удалить.");
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if(s.matches("[A-Za-z]+")){
                int k = Character.toUpperCase(s.charAt(0))-'A';
                if(list[k].size()!=0&&list[k].delete(s)){
                    System.out.println("Слово удалено.");
                }else{
                    System.out.println("Такого слова нет.");
                }
                return;
            }else{System.out.println("Некорректный ввод. Повторите еще раз.");}
        }
    }


}
