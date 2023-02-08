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
			contract.setValuePerHour(readDouble("Value per hour: "));
			contract.setHours(readInteger("Duration (hours): "));
			list.add(contract);
		}	
		return list;
	}
	
	public String chooseLevel() {
		String level = "";
		Integer option = 0;
		
		option = readInteger("Choose the level: \n1)Junior \n2)MID Level \n3)Senior");
		
		switch(option) {
			case 1:
				level = "JUNIOR";
				break;
			
			case 2:
				level = "MID_LEVEL";
				break;
				
			case 3:
				level = "SENIOR";
				break;
			
			default:
				System.out.println("Invalid option!");
				level = chooseLevel();
		}
		
		return level;
	}
	
	Scanner sc = new Scanner(System.in);
	public String readString(String text) {
		System.out.println(text);
		return sc.nextLine();
	}
	
	public Integer readInteger(String text) {
		System.out.println(text);
		return sc.nextInt();
	}
	
	public Double readDouble(String text) {
		System.out.println(text);
		return sc.nextDouble();
	}
}
