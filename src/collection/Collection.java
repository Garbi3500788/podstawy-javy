package collection;

import kwiaciarnia.Flower;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>() ;

        Set<Flower>  setList= new HashSet<>() ;

        linkedList.add(0,"Zofia");
        linkedList.add(1,"AAAA");
        Collections.sort(linkedList);
        System.out.println("Lista :" + linkedList);


    }
}
