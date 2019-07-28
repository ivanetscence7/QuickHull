import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String args[]) {
        int countTest = rnd(3, 5);
        for (int k = 0; k < countTest; k++) {
            System.out.println("Test: " + (k + 1) + "/" + countTest);
            int N = rnd(3, 10);
            //int N = 3000;

            ArrayList<Point> points = new ArrayList<Point>();
            ArrayList<Point> point = new ArrayList<Point>();
            for (int i = 0; i < N; i++) {
                Point v = new Point(rnd(1, 100), rnd(1, 100));
                //Point v = new Point(i+1,i+1);
                point.add(i, v);
                points.add(i, v);
            }

            System.out.println("Наши точки: ");
            points.stream().forEach(temp -> System.out.println("(" + temp.x + ", " + temp.y + ")"));
            System.out.println();

            BruteForce brute = new BruteForce();
            QuickHull newQuickHull = new QuickHull();

            long startTime = System.currentTimeMillis();
            Set<Point> absolutelyBruteForce = brute.absolutelyBruteForce(point);
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Точки по Brute Force: ");
            absolutelyBruteForce.stream().forEach(temp -> System.out.println("(" + temp.x + ", " + temp.y + ")"));
            System.out.println("Время по Brute Force: " + endTime);

            long startTimeThree = System.currentTimeMillis();
            Set<Point> resultSet = newQuickHull.printHull(point, N);
            long endTimeThree = System.currentTimeMillis() - startTimeThree;
            System.out.println("Точки по Quick Hull: ");
            resultSet.stream().forEach(temp -> System.out.println("(" + temp.x + ", " + temp.y + ")"));
            System.out.println("Время по Quick Hull: " + endTimeThree);
        }
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
