package com.rhyan.eightPointDirection;

public enum Direction {
	NORTH ("North"),
	NORTHEAST ("Northeast"),
	EAST ("East"),
	SOUTHEAST ("Southeast"),
	SOUTH ("South"),
	SOUTHWEST ("Southwest"),
	WEST ("West"),
	NORTHWEST ("Northwest");

	private String direction;

	private Direction(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return direction;
	}

	/**
	 * Returns the Direction immediately clockwise of this Direction.
	 * @return Direction
	 */
	public Direction clockwise() {
		Direction d;
		try {
			d = Direction.values()[this.ordinal() + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			d = NORTH;
		}
		return d;
	}

	/**
	 * Returns the Direction a number facings clockwise of this Direction.
	 * @return Direction
	 */
	public Direction clockwise(int steps) {
		Direction d = this;
		for (int i = 0; i < steps; i++)
			d = d.clockwise();

		return d;
	}

	/**
	 * Returns the Direction immediately counterclockwise of this Direction.
	 * @return Direction
	 */
	public Direction counterClockwise() {
		Direction d;
		try {
			d = Direction.values()[this.ordinal() - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			d = NORTHWEST;
		}
		return d;
	}

	/**
	 * Returns the Direction a number facings counterclockwise of this Direction.
	 * @return Direction
	 */
	public Direction counterClockwise(int steps) {
		Direction d = this;
		for (int i = 0; i < steps; i++)
			d = d.counterClockwise();

		return d;
	}

	/**
	 * Returns the Direction opposite of this Direction.
	 * @return Direction
	 */
	public Direction oppositeDirection() {
		return counterClockwise(4);
	}

	/**
	 * Returns True if North, East, South, or West.
	 * @return boolean
	 */
	public boolean isCardinalDirection() {
		return (this.ordinal()+1) % 2 != 0;
	}

	/**
	 * Returns -1 if North, 1 if South and 0 if neither. 
	 * @return int
	 */
	public int northOrSouth() {
		switch (this) {
		case NORTH:
		case NORTHWEST:
		case NORTHEAST:
			return -1;
		case SOUTH:
		case SOUTHWEST:
		case SOUTHEAST:
			return 1;
		default:
			return 0;
		}
	}

	/**
	 * Returns 1 if East, -1 if West, or 0 if neither.
	 * @return int
	 */
	public int eastOrWest() {
		switch (this) {
			case EAST:
			case NORTHEAST:
			case SOUTHEAST:
				return 1;
			case WEST:
			case NORTHWEST:
			case SOUTHWEST:
				return -1;
			default:
				return 0;
		}
	}
}

