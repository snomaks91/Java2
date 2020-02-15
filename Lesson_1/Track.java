package Lesson_1;

public class Track implements Course{

    private int length = 15;


    @Override
    public int jump(int maxJump) {
        return maxJump;
    }

    public int run (int maxRun) {
        if (maxRun >= length) {
            System.out.println("Смог пробежать");
            return 1;
        } else {
            System.out.println("Не хватило сил пробежать");
            return 0;
        }
    }
}
