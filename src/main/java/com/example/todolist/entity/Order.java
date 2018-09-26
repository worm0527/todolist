package com.example.todolist.entity;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 4279385292476045689L;

    private String id;

    private String name;

    private String messageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public static void main(String[] args) {
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s1.intern());
//        System.out.println(test());

//        A ab = new B();
//        ab = new B();

        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                System.out.println(a.getClass().getName());
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }

    public static int test() {
        int a = 1;

        try {
            a = 3;
            return a;
        } finally {
            a = 4;
            return a;
        }
    }

}

class A {

    {
        System.out.println("AAAAA");
    }

    static {
        System.out.println("1");
    }

    public A() {
        System.out.println("2");
    }
}

class B extends A {

    {
        System.out.println("BBBBBBBBBBBBBB");
    }

    static {
        System.out.println("a");
    }

    public B() {
        System.out.println("b");
    }
}

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}