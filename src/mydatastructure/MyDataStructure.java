package mydatastructure;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import mydatastructure.interfaces.MyDataStructureInterface;

public class MyDataStructure implements MyDataStructureInterface{

	Queue<Double> queue = new LinkedList<Double>();
	List<Double> inputList = new ArrayList<>();//	record the input numbers
	List<Double> outputList = new ArrayList<>();//	record the output results print purpose
	int N = 3;//default 3
	double sum = 0.0;
	double avg = 0.0;
	
	public static void main(String[] args) throws ParseException {
		MyDataStructure myDataStructure = new MyDataStructure();
		/**
		 * get input number list from user's input 
		 * base on user's input, calculate the average each time when user adds a number
		 */
		myDataStructure.getInput();
		myDataStructure.printResult(myDataStructure.inputList, myDataStructure.outputList);
	}
	
	@Override
	public double movingAverageAdd(double num) {
		if ( queue.size() == N ) {
			sum -= queue.remove();
		}
		sum += num;
		addData(num);
		return sum/queue.size();
	}

	@Override
	public double getNumber(int index) {
		return inputList.get(index);
	}

	@Override
	public void addData(double num) {
		queue.add(num);
	}

	@Override
	public double getAvg() {
		return avg;
	}

	@Override
	public void setMovingAveragePeriod(int n) {
		N = n;
	}

	/*
	 * Helper Functions
	 */
	private void printResult(List<Double> input_data, List<Double> output_data) {
		String inputString = "Input Data: [";
		for(double num : input_data ) {
			inputString = inputString + num + ", ";
		}
		inputString = inputString.substring(0, inputString.length() - 2) + "]";
		System.out.println(inputString);
		
		String outputString = "Moving Average: [";
		for(double num : output_data ) {
			outputString = outputString + num + ", ";
		}
		outputString = outputString.substring(0, outputString.length() - 2) + "]";
		System.out.println(outputString);
	}
	
	private void getInput() throws ParseException {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please input the moving period (N): ");
		setMovingAveragePeriod(reader.nextInt());
		while(true) {
			System.out.println("Please enter the number (any letter to exit the program): ");
			if (reader.hasNext("[+-]?\\d+\\.?(\\d+)?") ) {
				double inputNumber = reader.nextDouble();
				inputList.add(inputNumber);
				outputList.add(movingAverageAdd(inputNumber));
			}else {
				System.out.println("Exiting...");
				break;
			}
		}
		reader.close();
	}
}
