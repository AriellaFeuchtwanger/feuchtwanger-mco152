package feuchtwanger.math;

public class UniqueStrings {

	public static void main(String[] args) {
		String array[] = new String[] { "A", "B", "B", "B", "C" };

		for (int i = 0; i < array.length; i++) {
			boolean present = false;
			for(int j = 0; j < i; j++){
				if(array[i].equalsIgnoreCase(array[j])){
					present = true;
				}
			}
			if(!present){
				System.out.println(array[i]);
			}
		}

	}
}
