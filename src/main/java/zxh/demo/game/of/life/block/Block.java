package zxh.demo.game.of.life.block;

import java.util.Objects;

/**
 * Block:
 * @author zhangxuhai
 * @date 2019/10/29
*/
public class Block {

    public void trySurvive(int neighborSum) {
        if (isAlive()) {
            if (neighborSum < 2 || neighborSum > 3) {
                setAlive(false);
            }
        } else {
            if (neighborSum == 3) {
                setAlive(true);
            }
        }
    }

    public static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private Point point;
    private boolean alive;

    public Block(int x, int y, boolean alive) {
        this.point = new Point(x, y);
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        String ansiRed = "\u001B[31m";
        String ansiReset = "\u001B[0m";
        return isAlive() ? ansiRed + "□" + ansiReset : "·";
    }

    public Point getPoint() {
        return point;
    }
}
