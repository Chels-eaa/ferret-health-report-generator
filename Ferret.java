public class Ferret {
    private String name;
    private double length; // in inches
    private double weight; // in pounds
    private String gender;
    private static int ferretCount = 0; // shared counter among all ferrets

    // No-argument constructor
    public Ferret() {
        this.name = "";
        this.length = 0;
        this.weight = 0;
        this.gender = "";
        ferretCount++;
    }

    // Constructor with arguments
    public Ferret(String name, double length, double weight, String gender) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.gender = gender.toLowerCase();
        ferretCount++;
    }

    // Copy constructor
    public Ferret(Ferret other) {
        this.name = other.name;
        this.length = other.length;
        this.weight = other.weight;
        this.gender = other.gender;
        ferretCount++;
    }

    // Getters
    public String getName() { return name; }
    public double getLength() { return length; }
    public double getWeight() { return weight; }
    public String getGender() { return gender; }
    public static int getFerretCount() { return ferretCount; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setLength(double length) { this.length = length; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setGender(String gender) { this.gender = gender.toLowerCase(); }

    // toString method
    public String toString() {
        return "Name: " + name +
               "\nGender: " + gender +
               "\nLength (in): " + length + " in." +
               "\nWeight (lb): " + weight + " lb.";
    }
}
