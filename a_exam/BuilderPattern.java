package a_exam;

class Person{
    private final String name;
    private final int age;


    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString() {
        return "%s (%d)".formatted(name, age);
    }
}

class PersonBuilder{
    private String name;
    private int age;

    private boolean ageSet;

    public static PersonBuilder create(){
        return new PersonBuilder();
    }

    public PersonBuilder withAge(int age){
        this.age = age;
        this.ageSet = true;
        return this;
    }

    public PersonBuilder withName(String name){
        this.name = name;
        return this;
    }

    public Person build(){
        if(name == null){
            throw new IllegalStateException("Must set name first");
        }
        if(!ageSet){
            throw new IllegalStateException("Must set age");
        }
        return new Person(name, age);
    }



}



public class BuilderPattern {
    public static void main(String[] args) {
        Person person = PersonBuilder.create()
            .withName("Siri")
            .withAge(42)
            .build();

        System.out.println(person.toString());
    }
}
