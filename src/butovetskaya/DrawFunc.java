package butovetskaya;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawFunc {

    private final Graphics2D g2;
    private final int centerX;
    private final int centerY;
    private final int step;
    private final List<Point> pointsFunc;

    public DrawFunc(Graphics2D g2, int centerX, int centerY, int step, List<Point> pointsFunc) {
        this.g2 = g2;
        this.centerX = centerX;
        this.centerY = centerY;
        this.step = step;
        this.pointsFunc = pointsFunc;
    }

    public void paintFunc() {
        g2.setColor(new Color(128, 0, 128));
        DrawPoints dp = new DrawPoints(g2, centerX, centerY, step, pointsFunc);
        dp.connectingPoints();
    }

}
