package com.epam.module5.task2.com.epam.moduleX.java8.task1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilePathChecker {
    public FilePathChecker() {
    }

    public static boolean checkPath(Path path) {
        boolean flag = false;
        IValidator iValidator = str -> {
            return str.contains("/filepath");
        };
        IValidator iValidator2 = new String()::contains;

        if (!iValidator.isEmpty(path.toString()) && iValidator2.validate(path.toString())) {
            flag = true;
        }

        return flag;
    }
}

class Runner {
    public static void main(String[] args) {
        add("sd", null);
       /* PersonFactory<FilePathChecker> filePathCheckerObj = FilePathChecker::new;

        Predicate<Boolean> booleanPredicate = aBoolean -> !aBoolean;
        System.out.println(booleanPredicate.and(aBoolean -> {
            return !aBoolean;
        }).test(true));
        Predicate<FilePathChecker> stringPredicate = filePathChecker -> {
            return filePathChecker != null;
        };
        System.out.println(stringPredicate.test(null));
        String pathString = "/filepath/folder1/folder2";
        Path path = Paths.get(pathString);
        System.out.println(FilePathChecker.checkPath(path));

        Function<String, Integer> function = Integer::valueOf;
        System.out.println(function.apply("555"));

        List<String> stringList = generateList();

        Stream<String> stringStream = stringList.stream().map(s -> s.substring(2,6)).sorted((o1, o2) -> o1.compareTo(o2));
        printList(stringStream);*/
    }

    private static List<String> generateList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("value1");
        stringList.add("value2");
        stringList.add("value3");
        stringList.add("value4");
        stringList.add("value5");
        stringList.add("value6");
        stringList.add("value1");
        stringList.add("value8");
        stringList.add("value89");
        stringList.add("value9");
        stringList.add("value10");
        return stringList;
    }

    private static void printList(Stream<String> stringStream) {
        stringStream.forEach(s -> System.out.println(s));

    }
    public static void  add(String key, Object val) {
    }
}
