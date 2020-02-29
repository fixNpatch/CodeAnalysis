import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class FileMapper {

    private HashMap<String, Integer> m;
    private ArrayList<String> dict;
    private ArrayList<String> mvf; // most valuable files

    FileMapper(){
        m = new HashMap<String, Integer>();
        dict = new ArrayList<String>();
        dict.add(".git");
        dict.add(".idea");
        dict.add("out");
    }

    // распознавание расширения файла
    private String getExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    private void openDir(String path){
        File fs = new File(path);
        File[] files = fs.listFiles();

        if (files != null)
            for (File file : files) {
                String extension = "";
                if (file.isDirectory() && !dict.contains(file.getName())) {
                    openDir(file.getAbsolutePath());
                }
                else {
                    extension = getExtension(file.getAbsoluteFile());
                    if(m.containsKey(extension)) m.put(extension, m.get(extension) + 1);
                    else m.put(extension, 1);

                }
            }
    }

    void CreateProjectMap(String path){
        // Создание карты проекта
        // 1. Подсчет количества файлов
        // 2. Распознавание расширений файлов.
        // 3. Определение основного языка back-end. (Для усложнения может быть несколько языков)
        // 4. Запись карты в файл.

        openDir(path);
        System.out.println(m);
    }
}
