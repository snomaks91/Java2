package Lesson_5;

public class Potoki{
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];
    float[] a1 = new float[HALF];
    float[] a2 = new float[HALF];
    static long b,d,c, a;
    boolean flag1 = false;
    boolean flag2 = false;

    public void zapolnenie() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println(a);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()-a);
    }

    public void razbivka() {
        a = System.currentTimeMillis();
        System.out.println("a = " + a);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.arraycopy(arr,0, a1,0, HALF);
        System.arraycopy(arr, HALF, a2,0, HALF);
        b = System.currentTimeMillis();
        System.out.println("Время разбивки " + (b - a));
        Potoki mass = new Potoki();
        new Thread(()-> mass.run1()).start();
        new Thread(()-> mass.run2()).start();
        System.out.println(d+b-a);
    }


    public static void main(String[] args) {
        Potoki mass = new Potoki();
        mass.zapolnenie();
        mass.razbivka();
    }

    public void run1() {
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        c = System.currentTimeMillis();
        System.out.println("Время 1го " + (c - b));
        flag1 = true;
    }
    public void run2() {
        for (int i = 0; i < a2.length; i++) {
            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a2, 0, arr, HALF, HALF);
        d = System.currentTimeMillis();
        System.out.println("Время 2го " + (d - b));
        flag2 = true;
    }
}
