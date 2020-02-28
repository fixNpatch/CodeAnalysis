import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program Started");

        // Пока что ручной ввод директории проекта
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter project path");
        String ProjectPath = sc.nextLine();

        // Mappers init
        FileMapper fileMapper = new FileMapper();
        FunctionMapper functionMapper = new FunctionMapper();

        System.out.println(ProjectPath);

        fileMapper.CreateProjectMap(ProjectPath);
        functionMapper.CreateFunctionMap();

    }

}
