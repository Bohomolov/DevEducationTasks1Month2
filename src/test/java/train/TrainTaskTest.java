package train;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TrainTaskTest {
    private final TrainTask trainTask;
    private final List<Train> trainList;
    public TrainTaskTest() {
        trainTask = new TrainTask();
        trainList = null;
    }

    static Stream<Arguments> trainTest() {
        Train train1 = new Train("right", 1, "11:00", 10);
        Train train2 = new Train("right", 1, "11:00", 20);
        Train train3 = new Train("right", 1, "10:00", 20);
        Train train4 = new Train("right", 0, "10:00", 20);
        Train train5 = new Train("left", 0, "10:00", 20);
        Train train6 = new Train("boston", 0, "10:00", 20);


        List<Train> trains_1 = new ArrayList<>();
        trains_1.add(train2);
        trains_1.add(train1);

        List<Train> trains_1_exp = new ArrayList<>();
        trains_1_exp.add(train1);
        trains_1_exp.add(train2);

        List<Train> trains_2 = new ArrayList<>();
        trains_2.add(train2);
        trains_2.add(train1);
        trains_2.add(train3);

        List<Train> trains_2_exp = new ArrayList<>();
        trains_2_exp.add(train3);
        trains_2_exp.add(train1);
        trains_2_exp.add(train2);


        List<Train> trains_3 = new ArrayList<>();
        trains_3.add(train2);
        trains_3.add(train1);
        trains_3.add(train3);
        trains_3.add(train4);

        List<Train> trains_3_exp = new ArrayList<>();
        trains_3_exp.add(train4);
        trains_3_exp.add(train3);
        trains_3_exp.add(train1);
        trains_3_exp.add(train2);
       List<Train> trains_4 = new ArrayList<>();
        trains_4.add(train2);
        trains_4.add(train1);
        trains_4.add(train3);
        trains_4.add(train4);
        trains_4.add(train5);
        trains_4.add(train6);

        List<Train> trains_4_exp = new ArrayList<>();
        trains_4_exp.add(train6);
        trains_4_exp.add(train5);
        trains_4_exp.add(train4);
        trains_4_exp.add(train3);
        trains_4_exp.add(train1);
        trains_4_exp.add(train2);


        return Stream.of(
                arguments(trains_1, trains_1_exp),
                arguments(trains_2, trains_2_exp),
                arguments(trains_3, trains_3_exp),
                arguments(trains_4, trains_4_exp)

        );
    }

    @ParameterizedTest(name = "train Test. Input data is {0}, {1} ")
    @MethodSource("trainTest")
    void trainTest_0(List<Train> inputList, List<Train> expected) {
        List<Train> actual = trainTask.trainSort(inputList);
        assertEquals(expected, actual);
    }
    @Test
    void trainTest_exception(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           trainTask.trainSort(trainList);
        }, "Array is null.");
    }

}
