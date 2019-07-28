import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public Set<Point> absolutelyBruteForce(ArrayList<Point> a) {
        Set<Point> s = new HashSet<Point>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int x1 = a.get(i).x;
                int x2 = a.get(j).x;
                int y1 = a.get(i).y;
                int y2 = a.get(j).y;

                int a1 = y1 - y2;
                int b1 = x2 - x1;
                int c1 = x1 * y2 - y1 * x2;
                int pos = 0, neg = 0;
                for (int k = 0; k < a.size(); k++) {
                    int c = a1 * a.get(k).x + b1 * a.get(k).y + c1;
                    if (c <= 0)
                        neg++;
                    if (c >= 0)
                        pos++;
                }
                if (pos == a.size() || neg == a.size()) {
                    s.add(a.get(i));
                    s.add(a.get(j));
                }
            }
        }
        return s;
    }
}
