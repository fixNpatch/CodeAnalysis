class FunctionMapper {

    void CreateFunctionMap(){
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
    }

}
