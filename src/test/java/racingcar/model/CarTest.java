package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	private Car car1 = new Car("chan");
	private Car car2 = new Car("dong");
	private Cars cars = new Cars();

	@Test
	@DisplayName("랜덤 숫자가 4 이상일 때만 자동차는 이동한다")
	public void car_move_by_random_number() {
		assertFalse(car1.shouldMove(3));
		assertTrue(car1.shouldMove(4));
		assertTrue(car1.shouldMove(5));
	}
	
}