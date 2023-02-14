package me.rexisn.Catprep.generics;

import java.util.Collection;

public  class IterablePrinter {
    public  static void  print(Collection<?> coll){
        coll.forEach(c -> {
            System.out.println(c);
        });

    }
}
