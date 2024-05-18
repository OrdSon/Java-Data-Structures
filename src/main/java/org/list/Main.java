package org.list;

import org.list.linked_list.CustomLinkedList;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.printf("Hello and welcome!");

        CustomLinkedList<String> list = new CustomLinkedList();
        list.add("primero xd");
        list.add("segundo xd");
        list.add("tercero xd");
        list.add("quatro xd");
        list.add("cinco xd");
        list.add(3,"infiltrado en indice 3, que deberia ser posicion 4");
        list.modify(1, "primero modificado xD");
        list.modify(list.getSize()-1, "cinco modificado xD" );
        list.delete(1);
        System.out.println(list.getSize());
        System.out.println(list.toString());
    }
}