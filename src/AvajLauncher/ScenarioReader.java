import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScenarioReader {
    private int numberOfChanges;
    private String fileName;
    private Scanner sc;
    ArrayList<Flyable> airport;
    private WeatherTower wt;
    private  boolean isValidated = false;

    public ScenarioReader(String filename) {
        this.airport = new ArrayList<Flyable>();
        this.fileName = filename;
        this.wt = new WeatherTower();
    }

    public void runScenario() {
        if(!this.isValidated) {
            System.out.println("The file must be validated first");
            return ;
        }

        for(int i = 0; i < this.numberOfChanges; i++) {
            this.wt.changeWeather();
        }

    }

    public void validateFile() {
        File scenario = new File(this.fileName);
        try {
            this.sc = new Scanner(scenario);
            this.validateNumberOfChanges();
            while(sc.hasNext()) {
                validatePlanes(sc.nextLine());
            }
            this.sc.close();
            this.isValidated = true;
            
        } catch(Exception error) {
            if(error instanceof FileNotFoundException) {
                System.err.println("File not found or corrupted");
            } else if(error instanceof InvalidNumberOfChangesException) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void validateNumberOfChanges() throws InvalidNumberOfChangesException {
        try {
            this.numberOfChanges = sc.nextInt();
            sc.nextLine();
            if(this.numberOfChanges < 1) {
                throw new InvalidNumberOfChangesException("The number of changes must be a positive integer greater then 0");
            }
        } catch(InputMismatchException error) {
            System.err.println("The first line must integer");
        }
    }

    private void validatePlanes(String line)  {
        AircraftFactory af = AircraftFactory.getInstance();
        String[] splited = line.split(" ");
        String type = splited[0];
        String name = splited[1];
        int longitude = Integer.valueOf(splited[2]);
        int latitude = Integer.valueOf(splited[3]);
        int height = Integer.valueOf(splited[4]);
        try {
            Coordinates coor = new Coordinates(longitude, latitude, height);
            Flyable newAircraft = af.newAircraft(type, name, coor);
            this.wt.register(newAircraft);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return ;
        }

    }

    class InvalidNumberOfChangesException extends Exception {
        public InvalidNumberOfChangesException(String message) {
            super(message);
        }
    }


}
