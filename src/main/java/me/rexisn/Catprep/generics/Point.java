package me.rexisn.Catprep.generics;
import java.util.HashMap;

public class Point<T> {
    protected T x,y ;
    public T getX() {
        return x;
    }
    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
    public HashMap location(){
        HashMap<String, T> coordinates = new HashMap<String, T>();
        coordinates.put("x",x);
        coordinates.put("y",y);
        return coordinates;
    }

    public static <T> boolean isEqual(T a , T b){
        return  a.equals(b);
    }

}
