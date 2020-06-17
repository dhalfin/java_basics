public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        final double Pi = 3.1415926536;
        return Pi * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        final double Pi = 3.1415926536;
        return (4 / 3) * Pi * Math.pow(radius, 3) ;
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        if(a + b > c || b + c > a || a + c > b) {
            return true;
        } else {
            return -1.0;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTriangleRightAngled() == true) {
            double p = (a + b + c) / 2;
            double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return S;
    }
}
