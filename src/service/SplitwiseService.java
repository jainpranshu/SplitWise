package service;

import constants.Errors;
//import dto.Expense;
import enums.ExpenseType;
import util.FileWriterUtil;
import util.ShowUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitwiseService {

	UserService userService = new UserService();

	public void splitExpense(String[] inp){
		if(ExpenseType.valueOf(inp[4+Integer.parseInt(inp[3])]).equals(ExpenseType.EXACT)){
			List<String> borrowers = new ArrayList<>();
			List<Double> splitShare = new ArrayList<>();
			int borrowerCount = Integer.parseInt(inp[3]);
			for(int i = 4; i<borrowerCount+4; i++){
				borrowers.add(inp[i]);
				splitShare.add(Double.valueOf(inp[i+borrowerCount+1]));
			}
			userService.splitExact(inp[1],Integer.parseInt(inp[2]),Integer.parseInt(inp[3]),borrowers,splitShare);
		} else
		if(ExpenseType.valueOf(inp[4+Integer.parseInt(inp[3])]).equals(ExpenseType.EQUAL)){
			int borrowerCount = Integer.parseInt(inp[3]);
			List<String> borrowers = new ArrayList<>(Arrays.asList(inp).subList(4, borrowerCount + 4));
			userService.splitEqual(inp[1],Integer.parseInt(inp[2]),Integer.parseInt(inp[3]),borrowers);

		} else
		if(ExpenseType.valueOf(inp[4+Integer.parseInt(inp[3])]).equals(ExpenseType.PERCENT)){
			List<String> borrowers = new ArrayList<>();
			List<Double> splitShare = new ArrayList<>();
			int borrowerCount = Integer.parseInt(inp[3]);
			for(int i = 4; i<borrowerCount+4; i++){
				borrowers.add(inp[i]);
				splitShare.add(Double.valueOf(inp[i+borrowerCount+1]));
			}
			userService.splitByPercent(inp[1],Integer.parseInt(inp[2]),Integer.parseInt(inp[3]),borrowers,splitShare);
		}else {
			System.out.println(Errors.INVALID_EXPENSE_TYPE);
		}
	}

	public void show(String[] inp){
		ShowUtil showUtil = new ShowUtil();
		ShowService showService = new ShowService(showUtil);
		if(inp.length == 1){
			showService.showAllBalance();
		}else{
			showService.showUserBalance(inp[1]);
		}
		FileWriterUtil.writeOutputToFile(showUtil.getShowList());
	}
}
