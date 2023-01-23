package com.ceshop;

import java.util.*;
import java.util.stream.Collectors;

public class Palindrome {

    public static void main(String[] args) {
        Boolean isPalindrome = checkIsPalindrome(args);
        System.out.println("The word is " + (isPalindrome ? "Palindrome" : "not Palindrome"));
    }

    private static Boolean checkIsPalindrome(String[] args) {
        Palindrome palyndrome = new Palindrome();
        List<Character> chars = palyndrome.getCharacters(args).stream().map(character -> Character.toUpperCase(character)).collect(Collectors.toList());
        Stack stack = palyndrome.extractStackFromChars(chars);
        Queue<Character> queue = new LinkedList<>();
        queue.addAll(chars);
        Boolean isPalindrome = true;
        for (int i = 0; i < chars.size(); i++) {
            isPalindrome = stack.pop() == queue.remove() ? isPalindrome : false;
        }
        return isPalindrome;
    }

    Palindrome(){

    }

    private static Stack<Character> extractStackFromChars(List<Character> chars) {
        Stack<Character> stack = new Stack<Character>();
        stack.addAll(chars);
        return stack;
    }

    private static List<Character> getCharacters(String[] args) {
        String word = args[0];
        List<Character> chars = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        return chars;
    }
}