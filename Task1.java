/*
Урок 2. Почему вы не можете не использовать API
*Получить исходную json строку из файла, используя FileReader или Scanner
Дана json строка вида:
String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
"{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
"{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.

*Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */


import java.io.File;
import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) {
        String filePath = "test.txt";
        String result = readInFile(filePath);
        System.out.println(result);

    }

    static String readInFile(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String[] data = {"Студент", "Получл", "по предмету"};
                String znak= "[]{};:\\\"+";
                String str = scanner.nextLine();
                str = str.replace("{", "");
                str = str.replace("}", "");
                str = str.replaceAll("\"", "");
                str = str.replace("[", "");
                str = str.replace("]", "");
                str = str.replace(":", "");
                str = str.replace(";", "");
                str = str.replace("+", "");
                str = str.replace("\\", "");
                str = str.replace("фамилия", "");
                str = str.replace("предмет", "");
                str = str.replace("оценка", "");
                str = str.replace(" ", "");
                String[] strData = str.split(",");
                for (int i = 0; i < strData.length; i++) {
                    stringBuilder.append(data[i]+ " ");
                    stringBuilder.append(strData[i]+ " ");
                }
                stringBuilder.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
