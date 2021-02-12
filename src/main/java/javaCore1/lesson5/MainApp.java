package javaCore1.lesson5;

public class MainApp {

    public static void main(String[] args) {
        Employee[] employees = {new Employee("Федоров Андрей Петрович", "qa engineer", "feydorov@ya.ru", "+89094321222", 75000, 28),
                new Employee("Иванов Иван Иванович", "java developer", "ivanov1@ya.ru", "+89091234522", 120000, 31),
                new Employee("Колчанов Павел Романович", "delivery leader", "kokchanov3@ya.ru", "+89094321642", 200000, 45),
                new Employee("Александров Александр Федорович", "senior java developer", "alexandrov4@ya.ru", "+8909487654", 150000, 41),
                new Employee("Петров Петр Петрович", "middle qa engineer", "petrov4@ya.ru", "+89094321333", 85000, 28)};
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}
