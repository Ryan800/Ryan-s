package com.ryan.wangbw.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangbw
 * @desc
 * @date 2015/11/16.
 */
public class AnnotationBase {

//    @Annotation
    public void annotatedMethod2() {
        //@Target
        //ANNOTATION_TYPE
        //CONSTRUCTOR
        //FIELD
        //LOCAL_VARIABLE
        //METHOD
        //PACKAGE
        //PARAMETER
        //TYPE 可以使用到一个类的任何元素上

        /**
         * @SuppressWarnings("unused")
         */
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface CustomAnnotationClass {
        public String author() default "danibuiza";
        public String date();
    }

    @CustomAnnotationClass(date = "2014-05-05")
    public class AnnotatedClass {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface CustomAnnotationMethod {
        public String author() default "danibuiza";
        public String date();
        public String description();
    }

    @CustomAnnotationMethod(date = "2014-05-05", description = "annotated method")
    public String annotatedMethod() {
        return "nothing niente";
    }

    public static void main(String[] args) {
        Class<AnnotatedClass> object = AnnotatedClass.class;
        Annotation[] annotations = object.getAnnotations();

    }
}
