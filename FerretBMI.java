public class FerretBMI {
    private Ferret ferret;

    // No-argument constructor
    public FerretBMI() {
        this.ferret = new Ferret(); // create new Ferret object to avoid null
    }

    // Constructor with Ferret reference
    public FerretBMI(Ferret ferret) {
        // prevent security hole by creating a copy
        this.ferret = new Ferret(ferret);
    }

    // Getter and setter with copy to prevent security holes
    public Ferret getFerret() {
        return new Ferret(ferret);
    }

    public void setFerret(Ferret ferret) {
        this.ferret = new Ferret(ferret);
    }

    // toString method
    public String toString() {
        return ferret.toString() +
               "\nBMI: " + String.format("%.2f", calcBMI()) +
               "\nStatus: " + determineWeightStatus();
    }

    // Calculate BMI
    public double calcBMI() {
        return (ferret.getWeight() * 7.03) / ferret.getLength();
    }

    // Determine weight status
    public String determineWeightStatus() {
        double bmi = calcBMI();
        String gender = ferret.getGender();

        if (gender.equals("male")) {
            if (bmi < 1.54) return "Underweight";
            else if (bmi <= 2.31) return "Healthy";
            else return "Overweight";
        } else { // female
            if (bmi < 1.49) return "Underweight";
            else if (bmi <= 2.25) return "Healthy";
            else return "Overweight";
        }
    }
}
