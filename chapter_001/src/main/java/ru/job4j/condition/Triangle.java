package ru.job4j.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод вычисляет площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1,
     * если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * Согласно неравенству треугольника, длина любой стороны треугольника
     * меньше суммы длин двух других сторон.
     *
     * Все три условия должны выполниться
     * ab < ac + bc;
     * ac < ab + bc;
     * bc < ab + ac;
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return true - если все три условия верны, false - если обратное.
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab < ac + bc) && (ac < ab + bc) && (bc < ab + ac);
    }

}
