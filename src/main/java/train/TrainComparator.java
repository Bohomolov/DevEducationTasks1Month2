package train;

import java.util.Comparator;

public class TrainComparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {

        String des1 = o1.getDestination();
        String des2 = o2.getDestination();
        int sComp = des1.compareTo(des2);

        if (sComp != 0) {
            return sComp;
        }

        Integer trainNumber1 = o1.getTrainNumber();
        Integer trainNumber2 = o2.getTrainNumber();
        int trn = trainNumber1.compareTo(trainNumber2);

        if (trn != 0) {
            return trn;
        }

        String time1 = o1.getDepartureTime();
        String time2 = o2.getDepartureTime();
        int sTime = time1.compareTo(time2);

        if (sTime != 0) {
            return sTime;
        }

        Integer seats1 = o1.getSeats();
        Integer seats2 = o2.getSeats();
        return seats1.compareTo(seats2);
    }
}
