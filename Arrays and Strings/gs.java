
import java.util.*;
import java.lang.*;
import java.io.*;

public class gs {
    /* package codechef; // don't place package name! */


    /* Name of the class has to be "Main" only if the class is public. */
    public static void main(String[] args) {
        B b = new B();
        System.out.println((b instanceof B));
        System.out.println((b instanceof B)&&(!(b instanceof A)));
        System.out.println((b instanceof B)&&(!(b instanceof C)));
    }

}
class A{}
class B extends A{}
class C extends B{}