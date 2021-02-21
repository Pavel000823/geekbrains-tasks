package javaCore2.lesson1.attemp2;

public class Wall extends Barrier {

    private int size;

    public Wall(int length) {
        setSize(length);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
