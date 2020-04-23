import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class FileMapper {

    private Configurator configurator;
    private Properties properties;
    private enum BaseLanguages {
        c,
        java,
        js,
        go,
        ts,
        php
    }
    private HashMap<String, Integer> m;
    private ArrayList<String> dict;
    private ArrayList<String> mvf; // most valuable files


    // Конструктор объекта FileMapper (Инициализация и выделение памяти)
    FileMapper(){
        m = new HashMap<String, Integer>();
        dict = new ArrayList<String>();
        dict.add(".git");
        dict.add(".idea");
        dict.add("out");
        properties = new Properties();
        configurator = new Configurator();
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
                else if (!file.isDirectory()) {
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

        // find max value
        Map.Entry<String, Integer> maxEntry = null;
        for(Map.Entry<String, Integer> entry : m.entrySet()){
            System.out.println(entry.getValue());
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        if (maxEntry.getKey() == null){
            System.out.println("Seems you joking. Is it really project?");
            return;
        }

        System.out.println("Most Recent Language: " + maxEntry.getKey());

        properties.setProperty("mrl", maxEntry.getKey());
        properties.setProperty("mrl_occur", maxEntry.getValue().toString());

        configurator.setProps(properties);
        configurator.saveProps();

//        try {
//            OutputStream output = new FileOutputStream("tmp/config.properties");
//            try {
//                properties.store(output, null);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
