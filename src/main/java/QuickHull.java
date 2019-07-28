import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuickHull {
    public Set<Point> hull = new HashSet<Point>();

    public QuickHull() {
    }

    public QuickHull(Set<Point> hull) {
        this.hull = hull;
    }

    int findSide(Point p1, Point p2, Point p) {
        int val = (p.y - p1.y) * (p2.x - p1.x) -
                (p2.y - p1.y) * (p.x - p1.x);
        if (val > 0)
            return 1;
        if (val < 0)
            return -1;
        return 0;
    }

    int lineDist(Point p1, Point p2, Point p) {
        return Math.abs((p.y - p1.y) * (p2.x - p1.x) -
                (p2.y - p1.y) * (p.x - p1.x));
    }

    public void quickHull(ArrayList<Point> a, int n, Point p1, Point p2, int side) {
        int ind = -1;
        int max_dist = 0;
        for (int i = 0; i < n; i++) {
            int temp = lineDist(p1, p2, a.get(i));
            if (findSide(p1, p2, a.get(i)) == side && temp > max_dist) {
                ind = i;
                max_dist = temp;
            }
        }
        if (ind == -1) {
            hull.add(p1);
            hull.add(p2);
            return;
        }
        quickHull(a, n, a.get(ind), p1, -findSide(a.get(ind), p1, p2));
        quickHull(a, n, a.get(ind), p2, -findSide(a.get(ind), p2, p1));
    }

    public Set<Point> printHull(ArrayList<Point> a, int n) {
        if (n < 3) {
            System.out.println("Должно быть: n > 2");
            return null;
        }

        int min_x = 0, max_x = 0;
        for (int i = 1; i < n; i++) {
            if (a.get(i).x < a.get(min_x).x)
                min_x = i;
            if (a.get(i).x > a.get(max_x).x)
                max_x = i;
        }
        quickHull(a, n, a.get(min_x), a.get(max_x), 1);
        quickHull(a, n, a.get(min_x), a.get(max_x), -1);
        return hull;

    }
}


