package javaCore2.lesson5;

public class ArrayCalculate implements Runnable {
    private final float[] source;
    private float[] receptacle;
    private final int positionForStart;


    public ArrayCalculate(float[] source, float[] receptacle, int positionForStart) {
        this.source = source;
        this.receptacle = receptacle;
        this.positionForStart = positionForStart;

    }
// System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)

    @Override
    public void run() {
        System.arraycopy(source, positionForStart, receptacle, 0, receptacle.length);
        for (int i = 0; i < receptacle.length; i++) {
            receptacle[i] = (float) (receptacle[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
