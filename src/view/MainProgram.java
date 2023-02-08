package view;

import java.text.ParseException;
import entities.enums.WorkerLevel;
import model.Departament;
import model.Worker;
import service.Menu;

public class MainProgram {
	public static void main(String[] args) throws ParseException {
		Menu menu = new Menu();
		Worker worker = new Worker();
		
		worker.setDepartament(new Departament(menu.readString("Enter department's name:")));
		System.out.println("Enter worker data:");
		worker.setName(menu.readString("Name:")); 
		worker.setLevel(WorkerLevel.valueOf(menu.chooseLevel()));
		worker.setBaseSalary(menu.readDouble("Base Salary:"));
		
		worker.setContracts(menu.contractList(menu.readInteger("How many contracts to this worker? ")));
		System.out.println("Enter year and month to calculate income: ");
		Integer year = menu.readInteger("Type the year (YYYY): ");
		Integer month = menu.readInteger("Type the month (m) or (mm): ");
		Double income = worker.income(year, month);
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament());
		System.out.println("Income for " + month + "/" + year + ": " + income);
	}
}
