package racingcar.model;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@Test
	@DisplayName("immutable List 생성 테스트")
	void create_immutable_list() {
		List<String> unmodifiableList = Stream.of("1", "2", "3")
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));

		assertThrows(UnsupportedOperationException.class,
			() -> unmodifiableList.add("4"));
	}
}
