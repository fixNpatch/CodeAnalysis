package strategies;

public class JavaParser implements IParser {
//
//    // распознавание расширения файла
//    private String getExtensionz(File filse) {
//        String fileName = filse.getName();
//        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
//            return fileName.substring(fileName.lastIndexOf(".")+1);
//        else return "";
//    }
//
//    private void openDira (String path){
//        File fs = new File(path);
//        File[] files = fs.listFiles();
//
//        if (files != null)
//            for (File file : files) {
//                String extension = "";
//                if (file.isDirectory() && !dict.contains(file.getName())) {
//                    openDira(file.getAbsolutePath());
//                }
//                else if (!file.isDirectory()) {
//                    extension = getExtensionz(file.getAbsoluteFile());
//                    if(m.containsKey(extension)) m.put(extension, m.get(extension) + 1);
//                    else m.put(extension, 1);
//
//                }
//            }
//    }



    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void ScanForSqlConnections() {
        System.out.println("IParser == JavaParser");


    }
}
