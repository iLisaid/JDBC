import DAO.CathedraDAO;
import DAO.FacultyDAO;
import DAO.TeacherDAO;
import Entity.Cathedra;
import Entity.Faculty;
import Entity.Teacher;

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        CathedraDAO cathedraDAO = new CathedraDAO();
        FacultyDAO facultyDAO = new FacultyDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose: \n 1.Faculty. \n 2.Cathedra. \n 3.Teacher. \n 4.Exit");
            start:switch (scanner.nextInt()){
                case 1:
                    while (true){
                        chose();
                        switch (scanner.nextInt()){
                            case 1:
                                System.out.println(facultyDAO.getAll());
                                break;
                            case 2:
                                System.out.println("Enter id.");
                                System.out.println(facultyDAO.getEntityById(scanner.nextLong()));
                                break;
                            case 3:
                                System.out.println("Enter id and name.");
                                System.out.println(facultyDAO.update(new Faculty(scanner.nextLong(),scanner.next())));
                                break;
                            case 4:
                                System.out.println("Enter name.");
                                System.out.println(facultyDAO.create(new Faculty(scanner.next())));
                                break;
                            case 5:
                                System.out.println("Enter id.");
                                System.out.println(facultyDAO.delete(scanner.nextLong()));
                                break;
                            case 6:
                                break start;
                            default:
                                System.out.println("Operation not found.");
                                break;
                        }
                    }
                case 2:
                    while (true){
                        chose();
                        switch (scanner.nextInt()){
                            case 1:
                                System.out.println(cathedraDAO.getAll());
                                break;
                            case 2:
                                System.out.println("Enter id.");
                                System.out.println(cathedraDAO.getEntityById(scanner.nextLong()));
                                break;
                            case 3:
                                System.out.println("Enter id, name and faculty.");
                                cathedraDAO.update(new Cathedra(scanner.nextLong(),scanner.next(), scanner.next()));
                                break;
                            case 4:
                                System.out.println("Enter name and faculty.");
                                cathedraDAO.create(new Cathedra(scanner.next(), scanner.next()));
                                break;
                            case 5:
                                System.out.println("Enter id.");
                                cathedraDAO.delete(scanner.nextLong());
                                break;
                            case 6:
                                break start;
                            default:
                                System.out.println("Operation not found.");
                                break;
                        }
                    }
                case 3:
                    while (true){
                        chose();
                        switch (scanner.nextInt()){
                            case 1:
                                System.out.println(teacherDAO.getAll());
                                break;
                            case 2:
                                System.out.println("Enter id.");
                                System.out.println(teacherDAO.getEntityById(scanner.nextLong()));
                                break;
                            case 3:
                                System.out.println("Enter id, name and cathedra.");
                                teacherDAO.update(new Teacher(scanner.nextLong(),scanner.next(), scanner.next()));
                                break;
                            case 4:
                                System.out.println("Enter name and cathedra.");
                                teacherDAO.create(new Teacher(scanner.next(), scanner.next()));
                                break;
                            case 5:
                                System.out.println("Enter id.");
                                cathedraDAO.delete(scanner.nextLong());
                                break;
                            case 6:
                                break start;
                            default:
                                System.out.println("Operation not found.");
                                break;
                        }
                    }
                case 4:
                    return;
                default:
                    System.out.println("Operation not found.");
                    break;
            }
        }
    }
    public static void chose(){
        System.out.println("Choose: \n 1.Read_all \n 2.Read_by_id \n 3.Update \n 4.Create \n 5.Delete \n 6.Back");
    }
}
