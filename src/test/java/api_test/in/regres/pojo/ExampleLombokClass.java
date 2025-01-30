package api_test.in.regres.pojo;

import lombok.Data;
/**
 *  это библиотека для сокращения кода в классах */
@Data
public class ExampleLombokClass {
    private String name;
    private int age;
    private boolean aBoolean =true;
}
class Example{
    public static void main(String[] args) {
        ExampleLombokClass exampleLombokClass = new ExampleLombokClass();
        exampleLombokClass.getAge();
        exampleLombokClass.hashCode();
        exampleLombokClass.toString();

    }
}

