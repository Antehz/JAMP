package com.epam.module3.task1;

import com.squareup.javapoet.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Anton_Hrychanok on 2017-02-26.
 */

public class Runner {

    public static final String PATH = "com.epam.module3.task1.generated";
    public static final String INTERFACE_NAME = "ICar";
    public static final String CLASS1_NAME = "Volkswagen";
    public static final String CLASS2_NAME = "Audi";
    public static final File sourcePath = new File("src/main/java");
    public static final String START = "start";
    public static final String STOP = "stop";
    public static final String ADDITIONAL = "additionalMethod";
    public static final String ANNOTATION_NAME = "LogIt";
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        generateFiles();
        ApplicationContext appContect = new AnnotationConfigApplicationContext(SpringConfg.class);

        CustomClassLoader myClassLoader = new CustomClassLoader();
        myClassLoader.invokeClassMethod(PATH + "." + CLASS1_NAME, START);
        System.out.println("__________________________________________________");
        myClassLoader.invokeClassMethod(PATH + "." + CLASS1_NAME, STOP);
        System.out.println("__________________________________________________");
        myClassLoader.invokeClassMethod(PATH + "." + CLASS1_NAME, ADDITIONAL);
        System.out.println("**************************************************");
        myClassLoader.invokeClassMethod(PATH + "." + CLASS2_NAME, START);
        System.out.println("__________________________________________________");
        myClassLoader.invokeClassMethod(PATH + "." + CLASS2_NAME, STOP);
        System.out.println("__________________________________________________");
        myClassLoader.invokeClassMethod(PATH + "." + CLASS1_NAME, ADDITIONAL);

    }

    private static void generateFiles() {
        generateInterface();
        generateClasses(CLASS1_NAME);
        generateClasses(CLASS2_NAME);
    }

    private static MethodSpec generateStopMethod(String methodName) {
        MethodSpec method = MethodSpec.methodBuilder(methodName)
                .returns(Boolean.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("logger.debug(\"Method stop is running..\")")
                .addStatement("$T.out.println(\"{This's STOP method. ClassLoader = \"+ this.getClass().getClassLoader())", System.class)
                .addStatement("logger.debug(\"Method stop finish\")")
                .addStatement("return false")
                .build();
        return method;
    }

    private static MethodSpec generateStartMethod(String methodName) {
        MethodSpec method = MethodSpec.methodBuilder(methodName)
                .returns(Boolean.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$T.out.println(\"{This's STOP method. ClassLoader = \"+ this.getClass().getClassLoader())", System.class)
                .addStatement("return true")
                .build();
        return method;
    }

    private static MethodSpec generateAddMethod(String methodName) {
        MethodSpec method = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("logger.debug(\"Method additionalMethod is running..\")")
                .addStatement("$T.out.println(\"{This's Additional method. ClassLoader = \"+ this.getClass().getClassLoader())", System.class)
                .addStatement("logger.debug(\"Method additionalMethod stopped..\")")
                .build();
        return method;
    }

    private static void generateClasses(String className) {
        ClassName superInterface = ClassName.get(PATH, INTERFACE_NAME);
        TypeSpec class1 = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec.builder(Logger.class,"logger",  Modifier.PRIVATE, Modifier.FINAL).initializer("$T.getLogger(this.getClass())", LoggerFactory.class).build())
                .addAnnotation(Component.class)
                .addSuperinterface(superInterface)
                .addMethod(generateStartMethod(START))
                .addMethod(generateStopMethod(STOP))
                .addMethod(generateAddMethod(ADDITIONAL))
                .build();
        buildClass(class1);
    }
    private static void generateInterface() {

        MethodSpec startMethod = MethodSpec.methodBuilder(START)
                .returns(Boolean.class)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .build();

        MethodSpec stopMethod = MethodSpec.methodBuilder(STOP)
                .returns(Boolean.class)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .build();
        //Generated class will be named SuperHero
        TypeSpec iCar = TypeSpec.interfaceBuilder(INTERFACE_NAME).addMethod(startMethod).addMethod(stopMethod).addModifiers(Modifier.PUBLIC).build();

        buildClass(iCar);
    }

    private static void buildClass(TypeSpec typeSpec) {
        JavaFile javaFile = JavaFile.builder(PATH, typeSpec)
                .build();
        try {
            javaFile.writeTo(sourcePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
