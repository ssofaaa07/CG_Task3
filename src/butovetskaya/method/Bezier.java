
package butovetskaya.method;
import butovetskaya.Point;

import java.util.ArrayList;
import java.util.List;

public class Bezier {

    List<Point> pointList;
    List<Point> addPoints = new ArrayList<>();

    public Bezier(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void calculation() {
        if (pointList.size() > 2) {
            for (double t = 0; t <= 1; t += 0.01) {
                Point coordBXAndBY = new Point(0, 0);
                calc(coordBXAndBY, pointList, t);
                addPoints.add(coordBXAndBY);
            }
        }
    }

    private void calc(Point BXAndBY, List<Point> points, double t) {
        BinomialCoefficient binomialCoefficient = new BinomialCoefficient(0);
        for (int i = 0; i < points.size(); i++) {
            binomialCoefficient.binomialCalc(points.size() - 1, i);
            double b = binomialCoefficient.getCoef();
            BXAndBY.setX(BXAndBY.getX() + b * Math.pow(t, i)
                    * (Math.pow(1 - t, points.size() - (i + 1)))
                    * points.get(i).getX());
            BXAndBY.setY(BXAndBY.getY() + b
                    * Math.pow(t, i) * (Math.pow(1 - t, points.size() - (i + 1)))
                    * points.get(i).getY());
        }
    }


    public List<Point> getAddPoints() {
        return addPoints;
    }
}

