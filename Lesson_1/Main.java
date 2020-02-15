package Lesson_1;

public class Main {

    public static void main(String[] args) {


        Actions[] team = {new Human(), new Cat(), new Robot(), new Cat()};
        Course[] course = {new Wall(), new Track(), new Wall()};
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < course.length; j++) {
                if ((course[j].jump(team[i].getMaxJump()) == 0) || (course[j].run(team[i].getMaxRun()) == 0))
                    j = course.length;
            }
            System.out.println("Участник закончил");
        }
    }
}
