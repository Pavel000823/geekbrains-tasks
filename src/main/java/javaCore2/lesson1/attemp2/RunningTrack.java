package javaCore2.lesson1.attemp2;

public class RunningTrack extends Barrier {

    private int size;

    public RunningTrack(int length) {
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
