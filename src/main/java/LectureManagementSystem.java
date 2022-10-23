import org.assignment1.*;
import org.assignment1.Module;
import org.assignment1.Student;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class LectureManagementSystem {

    public LectureManagementSystem() {}

    public static void main(String[] args) {

        //creating students
        Student commerceStudent = new Student("John", 23, "10/05/1997", 1);
        Student commerceStudent1 = new Student("Mary", 21, "10/05/2001", 2);
        Student commerceStudent2 = new Student("Lily", 22, "10/05/2000", 3);
        Student compStudent1 = new Student("Paul", 19, "10/05/2003", 4);
        Student compStudent2 = new Student("Phil", 25, "10/05/1997", 5);
        Student compStudent3 = new Student("Susan", 21, "10/05/2001", 6);

        //creating lecturers
        Lecturer lecturer1 = new Lecturer("Ann", 56, "10/07/1987", 100967);
        Lecturer lecturer2 = new Lecturer("Conor", 45, "10/07/1987", 100968);
        Lecturer lecturer3 = new Lecturer("Sophie", 65, "10/07/1987", 100969);
        Lecturer lecturer4 = new Lecturer("John", 32, "10/07/1987", 100970);

        //creating modules
        Module module = new Module("Software Engineering", "CT101", lecturer1);
        Module module1 = new Module("Machine Learning", "CT102", lecturer2);
        Module module2 = new Module("Finance", "C102", lecturer3);
        Module module3 = new Module("Accounting", "C101", lecturer4);
        Module module4 = new Module("Professional skills", "CT103", lecturer1);

        //creating courses
        CoursePackage computerScience = new CoursePackage("Computer Science", new DateTime(2020 - 01 - 04), new DateTime(2023 - 03 - 05));
        CoursePackage commerce = new CoursePackage("Commerce", new DateTime(2020 - 01 - 04), new DateTime(2023 - 03 - 05));
        ArrayList<CoursePackage> courses = new ArrayList<>();
        courses.add(computerScience);
        courses.add(commerce);

        //adding students to modules and vice versa
        compStudent1.addModule(module);
        compStudent1.addModule(module1);
        compStudent1.addModule(module4);

        compStudent2.addModule(module);
        compStudent2.addModule(module1);
        compStudent2.addModule(module4);

        compStudent3.addModule(module);
        compStudent3.addModule(module1);
        compStudent3.addModule(module4);

        module.addStudent(compStudent1);
        module.addStudent(compStudent2);
        module.addStudent(compStudent3);

        module1.addStudent(compStudent1);
        module1.addStudent(compStudent2);
        module1.addStudent(compStudent3);

        module4.addStudent(compStudent1);
        module4.addStudent(compStudent2);
        module4.addStudent(compStudent3);

        commerceStudent.addModule(module2);
        commerceStudent.addModule(module3);

        commerceStudent1.addModule(module2);
        commerceStudent1.addModule(module3);

        commerceStudent2.addModule(module2);
        commerceStudent2.addModule(module3);

        module2.addStudent(commerceStudent);
        module2.addStudent(commerceStudent1);
        module2.addStudent(commerceStudent2);

        module3.addStudent(commerceStudent);
        module3.addStudent(commerceStudent1);
        module3.addStudent(commerceStudent2);

        //adding lecturer to their modules
        lecturer1.addModule(module);
        lecturer1.addModule(module4);
        lecturer2.addModule(module1);
        lecturer3.addModule(module2);
        lecturer4.addModule(module3);

        //add modules to the course
        commerce.addModuleToCourse(module2);
        commerce.addModuleToCourse(module3);

        //adding modules to the course
        computerScience.addModuleToCourse(module);
        computerScience.addModuleToCourse(module4);
        computerScience.addModuleToCourse(module1);

        //Adding students to course but also to required models for each course
        commerce.addStudentsToCourse(commerceStudent);
        commerce.addStudentsToCourse(commerceStudent1);
        commerce.addStudentsToCourse(commerceStudent2);

        computerScience.addStudentsToCourse(compStudent1);
        computerScience.addStudentsToCourse(compStudent2);
        computerScience.addStudentsToCourse(compStudent3);

        //Printing courses, required modules, lecturer's details for these modules, students taking these courses and their details
        for(CoursePackage course:courses){
            System.out.println("Details for " + course.getCourseName());
            for(Module tempModule:course.getRequiredModules()){
                System.out.println("Required Modules: " + "\n" + tempModule);
            }
            for(Object tempStudent:course.getStudentsEnrolled()){
                System.out.println("Students Enrolled in " + course.getCourseName() + ":\n" + tempStudent);
            }
        }
    }
}
