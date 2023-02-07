package view;

import java.text.ParseException;
import entities.enums.WorkerLevel;
import model.Departament;
import model.Worker;
import service.Menu;

public class Principal {
	public static void main(String[] args) throws ParseException {
		Menu menu = new Menu();
		Worker worker = new Worker();
		
		worker.setDepartament(new Departament(menu.leString("Enter department's name:")));
		System.out.println("Enter worker data:");
		worker.setName(menu.leString("Name:")); 
		worker.setLevel(WorkerLevel.valueOf(menu.leString("Level: ")));
		worker.setBaseSalary(menu.leDouble("Base Salary:"));
		
		worker.setContracts(menu.contractList(menu.leInteiro("How many contracts to this worker? ")));
		System.out.println("Enter year and month to calculate income: ");
		Integer year = menu.leInteiro("Type the year (YYYY): ");
		Integer month = menu.leInteiro("Type the month (m) or (mm): ");
		Double income = worker.income(year, month);
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament());
		System.out.println("Income for " + month + "/" + year + ": " + income);
	}
}
