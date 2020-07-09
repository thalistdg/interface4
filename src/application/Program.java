package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		String path = "/home/thalis/in.txt";
		List<Employee> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String employeeCsv = br.readLine();
			
			while(employeeCsv != null) {
				String[] employee = employeeCsv.split(",");
				list.add(new Employee(employee[0], Double.parseDouble(employee[1])));
				employeeCsv = br.readLine();
			}
			
			Collections.sort(list);
			for (Employee a: list) {
				System.out.println(a.getName() + ", " + a.getSalary());
			}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
