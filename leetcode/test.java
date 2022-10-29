import java.io.*;
import java.util.Scanner;

class EmployeeTable {
    String path;
    File file;
    static int top_id = 0;

    public EmployeeTable(String path) throws Exception {
        this.path = path;
        file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }
    }

    class Employee {
        public String emp_name, dept, desig;
        public int id;

        public Employee(String emp_name, String dept, String desig) {
            this.id = ++top_id;
            this.emp_name = emp_name;
            this.dept = dept;
            this.desig = desig;
        }

        public Employee(int id, String emp_name, String dept, String desig) {
            this.id = id;
            this.emp_name = emp_name;
            this.dept = dept;
            this.desig = desig;
        }

        public void setID(int id) {
            this.id = id;
        }

        public String toString() {
            return "" + this.id + "," + this.emp_name + "," + this.dept + "," + this.desig + "\n";
        }
    }

    public void insertNewEmployee(String name, String dept, String desig) throws Exception {
        FileWriter fw = new FileWriter(file, true);
        Employee emp = new Employee(name, dept, desig);
        fw.write(emp.toString());
        fw.flush();
        fw.close();
    }

    public void getEmployeeByID(int id) throws Exception {
        Scanner in = new Scanner(file);
        String emp = null;
        try {
            while (true) {
                emp = in.nextLine();

                String[] details = emp.split(",");
                if (id == Integer.parseInt(details[0])) {
                    System.out.println("ID: " + details[0]);
                    System.out.println("Name: " + details[1]);
                    System.out.println("Department: " + details[2]);
                    System.out.println("Designation: " + details[3]);
                    System.out.println();
                }
            }
        } catch (Exception e) {
        }
        in.close();
    }

    public void getEmployeesByDesignation(String desig) throws Exception {
        Scanner in = new Scanner(file);
        String emp = null;
        try {
            while (true) {
                emp = in.nextLine();
                String[] details = emp.split(",");
                if (desig.equalsIgnoreCase(details[3])) {
                    System.out.println("ID: " + details[0]);
                    System.out.println("Name: " + details[1]);
                    System.out.println("Department: " + details[2]);
                    System.out.println("Designation: " + details[3]);
                    System.out.println();
                }
            }
        } catch (Exception e) {
        }
        in.close();
    }

    public void editEmployeeByID(int id, String oldName, String oldDept, String oldDesig, String newName,
         String newDept, String newDesig) throws Exception {
        Employee oldEmp = new Employee(id, oldName, oldDept, oldDesig);
        Employee newEmp = new Employee(id, newName, newDept, newDesig);
        String oldLine = oldEmp.toString();
        String newLine = newEmp.toString();

        Scanner sc = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            String e = sc.nextLine();
            buffer.append(e + "\n");
        }
        String fileContents = buffer.toString();
        System.out.println("Old contents of the file: \n" + fileContents);

        fileContents = fileContents.replaceAll(oldLine, newLine);
        System.out.println("New contents of the file: \n" + fileContents);

        FileWriter writer = new FileWriter(path);
        System.out.println("");
        writer.append(fileContents);
        writer.flush();
    }
}

public class Main_employ {
    public static void main(String[] args) throws Exception {
        String path = "D:\\java path\\Employee.txt";
        EmployeeTable database = new EmployeeTable(path);
        System.out.println("Writing records into the file...");
        database.insertNewEmployee("Harsh", "CSE", " Developer");
        database.insertNewEmployee("Aditiiii", "ECE", "Junior ");
        database.insertNewEmployee("Nachiket", "MECH", "Engineer");
        System.out.println("Get Employee By ID: ");
        database.getEmployeeByID(1);
        System.out.println("Get Employee By Designation: ");
        database.getEmployeesByDesignation("Engineer");
        System.out.println("Editing a record: ");
        database.editEmployeeByID(2, "Luhar", "ECE", "Engineer", "Vijay", "CSE", "Developer");
        
        System.gc();
    }
}