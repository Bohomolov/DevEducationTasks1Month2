package train;

import java.util.List;

public class TrainTask {

    public List<Train> trainSort(List<Train> trains) {
        if (trains == null){
            throw new IllegalArgumentException("Array is null.");
        }
        TrainComparator trainComparator = new TrainComparator();
        trains.sort(trainComparator);
        return trains;
    }
}
