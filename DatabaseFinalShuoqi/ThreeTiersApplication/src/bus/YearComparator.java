package bus;

import java.util.Comparator;

public class YearComparator implements Comparator<SportCar>{

	@Override
	public int compare(SportCar o1, SportCar o2) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(o1.getDate().substring(0, 4)) < Integer.parseInt(o2.getDate().substring(0, 4)))
			return +1;
		else if(Integer.parseInt(o1.getDate().substring(0, 4)) > Integer.parseInt(o2.getDate().substring(0, 4)))
			return  -1;
		else return 0;
	}

}
