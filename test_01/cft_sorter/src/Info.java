class Info {
    void helpText() {
        System.out.println("Параметры запуска: [-options_1] [-options_2] <file1> <file2> <file3>\n" +
                "[-options_1] : не обязательный.\n" +
                "\t-d сортировка по возрастания (по умолчанию).\n" +
                "\t-r сортировка по убыванию.\n" +
                "[-options_2] : обязательный.\n" +
                "\t-i целочисленный файл.\n" +
                "\t-s файл с текстом\n" +
                "<file1> обязательный.\n" +
                "\tимя выходного файла\n" +
                "<file2> обязательный.\n" +
                "\tимя входного файла\n" +
                "<file3> обязательный.\n" +
                "\tимя входного файла\n" +
                "пример - {-d -s out.txt in1.txt in2.txt}\n" +
                "пример - {-i out.txt in1.txt in2.txt}");
    }
}
