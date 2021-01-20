package train;

import java.util.Objects;

public class Train {
    private final String destination;
    private final int trainNumber;
    private final String departureTime;
    private final int seats;

    public Train(String destination, int trainNumber, String departureTime, int seats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "train.Train " +
                "Destination: " + destination +
                ", train.Train number: " + trainNumber +
                ", Departure time: " + departureTime +
                ", Number of seats: " + seats + ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainNumber == train.trainNumber &&
                seats == train.seats &&
                Objects.equals(destination, train.destination) &&
                Objects.equals(departureTime, train.departureTime);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + trainNumber;
        result = 31 * result + seats;
        result = 31 * result + departureTime.hashCode();
        result = 31 * result + destination.hashCode();
        return result;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getSeats() {
        return seats;
    }


}
