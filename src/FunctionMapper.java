import strategies.GoParser;
import strategies.IParser;
import strategies.JavaParser;
import strategies.PhpParser;

import java.util.Properties;

class FunctionMapper {

    private IParser IParser;
    private Configurator configurator;
    private Properties properties;

    FunctionMapper(){
        configurator = new Configurator();

        configurator.loadProps();
        properties = configurator.getProps();

        String s = properties.get("mrl").toString();


        /* ---------------------------------
        ------- Определение стратегии ------
        -----------------------------------*/

        if ("java".equals(s)) {
            IParser = new JavaParser();
        } else if ("php".equals(s)) {
            IParser = new PhpParser();
        } else if ("go".equals(s)) {
            IParser = new GoParser();
        } else {
            System.out.println("error with strategy choice");
        }

    }


    void CreateFunctionMap(){

        IParser.ScanForSqlConnections();

        // Возможны два подхода
        // 1.
        //    а) пробегаемся по "важным" файлам.
        //    б) ищем SQL выражения
        //    в) анализируем их
        // 2.
        //    а) находим точку входа
        //    б) от неё запускаем обход в ширину. Обходим функции. Формируем список связей.
        //    в) У нас получется некая структура данных, содержащая примерно следующее:
        //
        //      | Имя функции | Имя файла | Номер строки | Родитель функции (кто вызвал) |
        //
        //       последний пункт важен, так как потомков в одной точке может быть несколько
        //       и связаны они например паттерном стратегия
        //    г) во время обхода пытаемся найти SQL выражения.
        //    д) при успешном нахождении, вызываем StackTraceMessage(даже если есть решения, пишем вручную логгирование)
        //    е) анализируем выражения.


        // реализуем первый вариант.

    }

}
