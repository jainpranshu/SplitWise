import constants.Commands;
import service.InMemoryService;
import service.SplitwiseService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner scanner=new Scanner(System.in);
		Scanner scanner = new Scanner(new File(args[0]));
		InMemoryService inMemoryService=new InMemoryService();
		SplitwiseService splitwiseService=new SplitwiseService();
		while (scanner.hasNext()) {
			String inpStr= scanner.nextLine();
			String[] inp = inpStr.trim().split(" ");
			try {
				switch (inp[0]) {
					case Commands.EXPENSE: {
						System.out.println(inpStr);
						splitwiseService.splitExpense(inp);
						System.out.println("----------------------");
					}
					break;
					case Commands.SHOW: {
						System.out.println(inpStr);
						splitwiseService.show(inp);
						System.out.println("----------------------");
					}
					break;
					default: {
						System.out.println("INVALID INPUT");
					}
				}
			}
			catch (RuntimeException e){
				System.out.println(e);
			}
		}

	}
}