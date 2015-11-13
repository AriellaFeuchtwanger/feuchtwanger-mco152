package feuchtwanger.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	private HashMap<String, Boolean> seats;
	private int rows;
	private int columns;
	private String columnList;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		StringBuilder columnBuilder = new StringBuilder();
		HashSet<String> columnSet = new HashSet<String>();

		seats = new HashMap<String, Boolean>();
		for (int j = 1; j <= rows; j++) {
			for (int i = 1; i <= columns; i++) {
				String column = "";
				switch (i) {
				case 1:
					column = "A";
					break;
				case 2:
					column = "B";
					break;
				case 3:
					column = "C";
					break;
				case 4:
					column = "D";
					break;
				case 5:
					column = "E";
					break;
				case 6:
					column = "F";
					break;
				case 7:
					column = "G";
					break;
				case 8:
					column = "H";
					break;
				case 9:
					column = "I";
					break;
				case 10:
					column = "J";
					break;
				case 11:
					column = "K";
					break;
				case 12:
					column = "L";
					break;
				case 13:
					column = "M";
					break;
				case 14:
					column = "N";
					break;
				case 15:
					column = "O";
					break;
				case 16:
					column = "P";
					break;
				case 17:
					column = "Q";
					break;
				case 18:
					column = "R";
					break;
				case 19:
					column = "S";
					break;
				case 20:
					column = "T";
					break;
				case 21:
					column = "U";
					break;
				case 22:
					column = "V";
					break;
				case 23:
					column = "W";
					break;
				case 24:
					column = "X";
					break;
				case 25:
					column = "Y";
					break;
				case 26:
					column = "Z";
					break;
				}

				StringBuilder builder = new StringBuilder();
				builder.append(column);
				builder.append(j);
				columnSet.add(column);
				seats.put(builder.toString(), false);
			}
		}

		for (String s : columnSet) {
			columnBuilder.append(s);
		}

		columnList = columnBuilder.toString();
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException,
			SeatOutOfBoundsException {
		if (seats.containsKey(seatName)) {
			if (!isReserved(seatName)) {
				seats.put(seatName, true);
			} else {
				throw new AlreadyReservedException();
			}
		} else {
			throw new SeatOutOfBoundsException();
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return seats.get(seatName);
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided here for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("  ");
		builder.append(columnList);

		for (int j = 1; j <= rows; j++) {
			builder.append("\n");
			builder.append(j);
			builder.append(" ");
			for (int i = 0; i < columns; i++) {
				char column = columnList.charAt(i);

				StringBuilder seatName = new StringBuilder();
				seatName.append(column);
				seatName.append(j);
				for (Map.Entry<String, Boolean> e : seats.entrySet()) {
					if (e.getKey().equals(seatName.toString())) {
						if (e.getValue()) {
							builder.append("#");
						} else {
							builder.append("o");
						}
					}
				}
			}
		}

		builder.append("\n");
		return builder.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException,
			SeatOutOfBoundsException {
		ArrayList<String> seatGroup = new ArrayList<String>();

		if (numberOfSeatsTogether > columns) {
			throw new NotEnoughSeatsException();
		}

		for (int j = 0; j < columns; j++) {
			char column = columnList.charAt(j);
			for (int i = 1; i <= rows; i++) {
				StringBuilder seatName = new StringBuilder();
				seatName.append(column);
				seatName.append(i);
				for (Map.Entry<String, Boolean> e : seats.entrySet()) {
					if (e.getKey().equals(seatName.toString())) {
						if (!e.getValue()) {
							seatGroup.add(seatName.toString());
						} else {
							seatGroup = new ArrayList<String>();
						}
					}
				}
			}
			if (seatGroup.size() == numberOfSeatsTogether) {
				break;
			} else if (seatGroup.size() > numberOfSeatsTogether) {
				while (seatGroup.size() > numberOfSeatsTogether) {
					seatGroup.remove((seatGroup.size() - 1));
				}
				break;
			} else {
				seatGroup = new ArrayList<String>();
			}

		}
		if (seatGroup.size() == 0) {
			throw new NotEnoughSeatsException();
		}

		for (String s : seatGroup) {
			reserve(s);
		}
		return seatGroup;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (Map.Entry<String, Boolean> e : seats.entrySet()) {
			if (!e.getValue()) {
				return false;
			}
		}

		return true;
	}

}
