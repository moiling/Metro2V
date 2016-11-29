package com.findv.metro2v.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MOILING
 */
public class V {
    private List<Point> point = new ArrayList<>();
    private List<Line> line = new ArrayList<>();

    public V(List<Point> point, List<Line> line) {
        this.point = point;
        this.line = line;
    }

    public List<Point> getPoint() {
        return point;
    }

    public void setPoint(List<Point> point) {
        this.point = point;
    }

    public List<Line> getLine() {
        return line;
    }

    public void setLine(List<Line> line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        V v = (V) o;

        if (point != null ? !point.equals(v.point) : v.point != null) return false;
        return line != null ? line.equals(v.line) : v.line == null;
    }

    @Override
    public int hashCode() {
        int result = point != null ? point.hashCode() : 0;
        result = 31 * result + (line != null ? line.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "V{" +
                "point=" + point +
                ", line=" + line +
                '}';
    }
}
