import java.util.ArrayList;
import java.util.List;

// Generic interface for a TravelPackage
interface TravelPackageHandler<T> {
    void bookPackage(T packageItem);
    void displayPackageDetails(T packageItem);
}

// Generic class representing a TravelPackage
class TravelPackage<T> implements TravelPackageHandler<T> {
    private List<T> packages;

    public TravelPackage() {
        packages = new ArrayList<>();
    }

    @Override
    public void bookPackage(T packageItem) {
        packages.add(packageItem);
        System.out.println("Package booked: " + packageItem);
    }

    @Override
    public void displayPackageDetails(T packageItem) {
        System.out.println("Package details: " + packageItem);
    }

    // Additional generic method to display all packages
    public void displayAllPackages() {
        System.out.println("All booked packages: " + packages);
    }
}

// Example of a class representing a specific travel package
class CruisePackage {
    private String cruiseName;

    public CruisePackage(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    @Override
    public String toString() {
        return "CruisePackage{" +
                "cruiseName='" + cruiseName + '\'' +
                '}';
    }
}

// Example of a class representing a specific travel package
class TourPackage {
    private String tourName;

    public TourPackage(String tourName) {
        this.tourName = tourName;
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "tourName='" + tourName + '\'' +
                '}';
    }
}

public class TravelAgencyDemo {
    public static void main(String[] args) {
        // Create a TravelPackage for Cruise
        TravelPackage<CruisePackage> cruiseTravelPackage = new TravelPackage<>();
        CruisePackage cruisePackage = new CruisePackage("Caribbean Cruise");
        cruiseTravelPackage.bookPackage(cruisePackage);
        cruiseTravelPackage.displayPackageDetails(cruisePackage);

        // Create a TravelPackage for Tour
        TravelPackage<TourPackage> tourTravelPackage = new TravelPackage<>();
        TourPackage tourPackage = new TourPackage("Historical Tour");
        tourTravelPackage.bookPackage(tourPackage);
        tourTravelPackage.displayPackageDetails(tourPackage);

        // Display all booked packages
        cruiseTravelPackage.displayAllPackages();
        tourTravelPackage.displayAllPackages();
    }
}
