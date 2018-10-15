/*This code was created by Eliza Paradise in collaboration with Katelyn Chang, Ana Martinez, and Jonathan Pittman as part 
of a submission to the HackDuke2018: Code for Good Health Track. This algorithm works to track and predict periods. 
Visit gowithyourflow.net to see a prototype of the final product (still in progress!) */

import java.util.ArrayList;
import java.util.TreeMap;

public class HackDuke2018 {
	public static int[] predict(TreeMap<String, ArrayList<Integer>> pastDates, String mostRecent) {
		TreeMap<String, Integer> numdays = new TreeMap<>();
		numdays.put("January", 31);
		numdays.put("February", 28);
		numdays.put("March", 31);
		numdays.put("April", 30);
		numdays.put("May", 31);
		numdays.put("June", 30);
		numdays.put("July", 31);
		numdays.put("August", 31);
		numdays.put("September", 30);
		numdays.put("October", 31);
		numdays.put("November", 30);
		numdays.put("December", 31);
		ArrayList<String> months = new ArrayList<String>();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
		boolean leapYear = false;
		int avglength = 0;
		int timebw = 0;
		int prevend = 0;
		int numperiods = 0;
		int prevnumdays = 0;
		String prevmonth = "";
		for (String k: pastDates.keySet()) {
			leapYear = false;
			String[] monthyear = k.split(" ");
			String month = monthyear[0];
			int year = Integer.parseInt(monthyear[1]);
			if (month.equals("February")) {
				if ((year%4 == 0 && year%100 != 0) || year%400==0) {
					leapYear = true;
				}
			}
			int days = numdays.get(month);
			if (leapYear) {
				days++;
			}
			ArrayList<Integer> dates = pastDates.get(k);
			int length = dates.get(1) - dates.get(0) + 1;
			avglength += length;
			if (dates.size() > 2) {
				timebw += (dates.get(2) - dates.get(1));
				if (dates.get(3) > dates.get(2) && dates.get(3) <= days) {
					avglength += ((dates.get(3)) - dates.get(2) + 1);
				}
				else avglength += ((days + dates.get(3)) - dates.get(2) + 1);
				numperiods++;
			}
			if (prevend != 0){
				timebw += ((prevnumdays + dates.get(0)) - prevend);
			}
			if (dates.size() > 2) {
				prevend = dates.get(3);
			}
			else prevend = dates.get(1);
			prevnumdays = days;
			numperiods++;
		}
		leapYear = false;
		avglength = avglength/numperiods;
		timebw = timebw/(numperiods - 1);
		ArrayList<Integer> last = pastDates.get(mostRecent);
		int predictedstart = 0;
		if (last.size() == 2) {
			predictedstart = last.get(1) + timebw;
		}
		else {
			predictedstart = last.get(3) + timebw;
		}
		String[] split = mostRecent.split(" ");
		String month = split[0];
		int year = Integer.parseInt(split[1]);
		if (last.size() > 2) {
			String pmonth = "";
			for (String mymonth: months) {
				if (pmonth.equals(month)) {
					month = mymonth;
					break;
				}
				pmonth = mymonth;
			}
		}
		System.out.println(month);
		if ((year%4 == 0 && year%100 != 0) || year%400==0) {
			leapYear = true;
		}
		if (numdays.get(month) == 30) {
			if (predictedstart > 30) {
				predictedstart -= 30;
			}
		}
		if (month.equals("February")) {
			if (!leapYear) {
				if (predictedstart > 28) {
					predictedstart -= 28;
				}
			}
			if (leapYear) {
				if (predictedstart > 29) {
					predictedstart -= 29;
				}
			}
		}
		else {
			if (predictedstart > 31) {
				predictedstart -= 31;
			}
		}
		int predictedend = predictedstart + avglength;
			if (numdays.get(month) == 30) {
			if (predictedend > 30) {
				predictedend -= 30;
			}
		}
		if (month.equals("February")) {
			if (!leapYear) {
				if (predictedend > 28) {
					predictedend -= 28;
				}
			}
			if (leapYear) {
				if (predictedend > 29) {
					predictedend -= 29;
				}
			}
		}
		else {
			if (predictedend > 31) {
				predictedend -= 31;
			}
		}
		int [] ret = new int[4];
		ret[0] = predictedstart;
		ret[1] = predictedend;
		ret[2] = avglength;
		ret[3] = timebw;
		return ret;
	
	}
	
	public static void main(String[] args) {
		TreeMap<String, ArrayList<Integer>> myPeriod = new TreeMap<>();
		ArrayList<Integer> june = new ArrayList<Integer>();
		june.add(5);
		june.add(10);
		myPeriod.put("June 2018", june);
		ArrayList<Integer> july = new ArrayList<Integer>();
		july.add(4);
		july.add(9);
		myPeriod.put("July 2018", july);
		ArrayList<Integer> august = new ArrayList<Integer>();
		august.add(3);
		august.add(8);
		ArrayList<Integer> september = new ArrayList<Integer>();
		september.add(2);
		september.add(8);
		september.add(30);
		september.add(5);
		myPeriod.put("September 2018", september);
		int[] prediction = predict(myPeriod, "September 2018");
		System.out.println("Predicted start date: " + prediction[0]);
		System.out.println("Predicted end date: " + prediction[1]);
		System.out.println("Avg length: " + prediction[2]);		
		System.out.println("Time bw: " + prediction[3]);
	}
}
