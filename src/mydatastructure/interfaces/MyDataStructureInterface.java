package mydatastructure.interfaces;

/**
 * Use Queue to calculate the moving average since Queue is First In First Out
 * We just use a Queue of size N and when adding a new number
 * Dequeue the first number when the queue is full
 * Calculate the average base on current Queue list size ( when queue is full it is just N )
 * In this case, the whole process will be O(1)
 * 
 * @author Chris Wang
 *
 */
public interface MyDataStructureInterface {
	
	/**
	 * set the moving period number of N in the moving average
	 * @param n
	 */
	void setMovingAveragePeriod ( int n );
	
	/**
	 * add the number in the queue to calculate the moving average
	 * @param num
	 */
	void addData(double num);
	
	/**
	 * calculate the moving average when adding a number base on moving period
	 * @param num
	 * @return
	 */
	double movingAverageAdd(double num);
	
	/**
	 * base on the index return the number in the list
	 * @param index
	 * @return
	 */
	double getNumber(int index);
	
	/**
	 * return the current average ( the average after adding the last number )
	 * @return
	 */
	double getAvg();
}
