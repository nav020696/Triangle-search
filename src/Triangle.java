import java.io.*;
import java.util.ArrayList;

public class Triangle {
    public static void main(String[] args) throws IOException {
        String fi1e1 = args[0]; //имя входного файла
        String file2 = args[1]; //имя выходного файла
        BufferedReader reader = new BufferedReader(new FileReader(fi1e1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        double max_square = 0;
        String str_max_square = "";
        while(reader.ready()){
            String s = reader.readLine();
            ArrayList<Integer> result_coordinates = coordinates(s);
            if (result_coordinates.size() == 6){
                if(isosceles(result_coordinates)){
                    double result = square(result_coordinates);
                    if(result > max_square){
                        max_square = result;
                        str_max_square = s;
                    }
                }
            }
        }
        reader.close();
        writer.write(str_max_square); //Записываем строку координат треугольника с максимальной площадью
        writer.close();
    }

    //Метод, который преобразует строку в массив координат типа int
    public static ArrayList<Integer> coordinates(String s){
        String[] coordinate = s.split(" ");
        ArrayList<Integer> coordinates = new ArrayList<>();
        if (coordinate.length == 6){
            try{
                for(int i=0; i<coordinate.length; i++){
                   coordinates.add(Integer.parseInt(coordinate[i]));
                }
            } catch (Exception e){
                return coordinates;
            }
        }
        return coordinates;
    }

    //Метод, который проверяет является ли треугольник равнобедренным
    public static boolean isosceles(ArrayList<Integer> arr){
        boolean result = false;
        double dl1 = Math.sqrt(Math.pow(arr.get(2) - arr.get(0), 2) + Math.pow(arr.get(3) - arr.get(1), 2));
        double dl2 = Math.sqrt(Math.pow(arr.get(4) - arr.get(0), 2) + Math.pow(arr.get(5) - arr.get(1), 2));
        double dl3 = Math.sqrt(Math.pow(arr.get(4) - arr.get(2), 2) + Math.pow(arr.get(5) - arr.get(3), 2));
        if (((dl1 == dl2) || (dl1 == dl3) || (dl2 == dl3)) && dl1 !=0 && dl2!=0 && dl3!=0 ){
            result = true;}

        return result;
    }

    //Метод, который возвращает площадь треугольника по точкам
    public static double square (ArrayList<Integer> arr){
        return 0.5 * Math.abs((arr.get(2) - arr.get(0))* (arr.get(5) - arr.get(1)) - (arr.get(4) - arr.get(0)) * (arr.get(3) - arr.get(1)));
    }
}
