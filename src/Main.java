import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program Started");

        // Пока что ручной ввод директории проекта
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter project path");
        String ProjectPath = sc.nextLine();


        System.out.println(ProjectPath);


        // Mappers init
        FileMapper fileMapper = new FileMapper();
        fileMapper.CreateProjectMap(ProjectPath);


        FunctionMapper functionMapper = new FunctionMapper(); // во время создания конструктора определяется стратегия
        functionMapper.CreateFunctionMap();

    }

}
