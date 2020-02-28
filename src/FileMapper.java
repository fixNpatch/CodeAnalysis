import java.io.File;

class FileMapper {

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
                if (file.isDirectory())
                    openDir(file.getAbsolutePath());
                else {
                    extension = getExtension(file.getAbsoluteFile());
                    //  Map[extension]++;
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
    }

}
