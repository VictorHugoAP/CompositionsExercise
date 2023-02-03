package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.HourContract;

public class Menu {
	public Menu() {
	}
	
	public List<HourContract> contractList(Integer number) throws ParseException {
		List<HourContract> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int i = 0; i < number; i++) {
			HourContract contract = new HourContract();		
			
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.println("Date (DD/MM/YYYY): ");
			contract.setDate((sdf.parse(sc.next())));
			contract.setValuePerHour(leDouble("Value per hour: "));
			contract.setHours(leInteiro("Duration (hours): "));
			list.add(contract);
		}	
		return list;
	}
	
	Scanner sc = new Scanner(System.in);
	public String leString(String texto) {
		System.out.println(texto);
		return sc.nextLine();
	}
	
	public Integer leInteiro(String texto) {
		System.out.println(texto);
		return sc.nextInt();
	}
	
	public Double leDouble(String texto) {
		System.out.println(texto);
		return sc.nextDouble();
	}
	
}
