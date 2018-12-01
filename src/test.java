import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("files/VehicleList.csv"));
            while (input.hasNextLine()) {
                String v = input.nextLine();
                String[] info = v.split(",");
                switch (info[0]) {
                    case "Truck" :
                        vehicles.add(new Truck(info[1],Double.parseDouble(info[2])));
                        break;

                    case "Drone" :
                        vehicles.add(new Drone(info[1],Double.parseDouble(info[2])));
                        break;

                    case "Cargo Plane" :
                        vehicles.add(new CargoPlane(info[1],Double.parseDouble(info[2])));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(vehicles.get(0).getLabels());
    }
}
