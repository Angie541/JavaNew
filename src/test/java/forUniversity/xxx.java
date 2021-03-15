package forUniversity;

import java.lang.*;
import java.text.DecimalFormat;
import java.util.*;

class Project {
    static int num = 53;

    public static void main(String[] arg) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, Enter start value: ");
        double startX = scanner.nextDouble();

        System.out.println("Please, Enter end value: ");
        double endX = scanner.nextDouble();

        System.out.println("Please, Enter deltaX: ");
        double deltaX = scanner.nextDouble();
        if (deltaX == 0 || ((endX - startX) / deltaX) <= 0) {
                throw new Exception("Incorrect value");
        }

        System.out.format("|" + "                 № строки" + "|" + "               значение x" + "|" + "               результат" + "|\n");
        System.out.format("|-------------------------|-------------------------|------------------------|\n");
        double x = startX;
        long finalI = (long) ((endX - startX) / deltaX);
         for (long i = 0; i <= finalI; i++)
        {
        double result = Math.min(function1(x), function2(x));

        String resultValue;
            if (Double.isNaN(result)) {
                resultValue = "error";
            } else {
                DecimalFormat df = new DecimalFormat("#.#######");
                resultValue = String.valueOf(df.format(result));
            }
            System.out.format("|" + "%26s%26s%26s", i + "|", x + "|", resultValue + "|\n");
            x += deltaX;
        }
    }

    static double convertTheAnglesToRadians(double x){
        return ((x * Math.PI) / 180.0);
    }

    static double function1 (double x) {
        double value = Math.cos(convertTheAnglesToRadians(x- num));
      if (value >= 0){
        return Double.NaN;
        }
        return Math.log((1 - num) / value);
    }

    static double function2(double x){
        if ((Math.abs(x) % 90.0 < 0.0001 || Math.abs(x) % 90.0 > 89.99999) && !(Math.abs(x) % 180.0 < 0.00001 || Math.abs(x) % 180.0 > 179.99999)){
            return Double.NaN;
        }
        return Math.tan(convertTheAnglesToRadians(x)) / num;
    }
}