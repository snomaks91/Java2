package Lesson_1;

public class Wall implements Course{

    private int height = 15;

    public int run(int maxRun) {
        return maxRun;
    }

    @Override
    public int jump(int maxJump) {
        if (maxJump >= height) {
            System.out.println("Смог перепрыгнуть");
            return 1;
        } else {
            System.out.println("Не хватило сил прыгнуть");
            return 0;
        }
    }
}
