package academy.elqoo.java8.defaultmethods;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public interface Shape {

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){
        return "";
    }

    default void move(int x, int y){
        setXPos(x);
        setYPos(y);
    }

    static void moveXPosWith10(List<AbstractShape> shapes) {
        shapes.stream().forEach ((s)->s.setXPos(s.getXPos()+10));
    }

    default void notImplementedMethod() {
        throw new NotImplementedException();
    }
}
