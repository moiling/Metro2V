package com.findv.metro2v.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MOILING
 */
public class Line {
    private int id;
    private String name;
    private List<Integer> path = new ArrayList<>();

    public Line(int id, String name, List<Integer> path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPath() {
        return path;
    }

    public void setPath(List<Integer> path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (id != line.id) return false;
        if (name != null ? !name.equals(line.name) : line.name != null) return false;
        return path != null ? path.equals(line.path) : line.path == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path=" + path +
                '}';
    }
}
