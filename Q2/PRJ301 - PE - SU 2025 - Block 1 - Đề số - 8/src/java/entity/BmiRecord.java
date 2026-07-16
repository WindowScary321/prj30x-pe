package entity;

public class BmiRecord {
    private int height;
    private int weight;
    private double BMI;
    private String Conclude;

    public BmiRecord() {
    }

    public BmiRecord(int height, int weight, double BMI, String Conclude) {
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.Conclude = Conclude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getConclude() {
        return Conclude;
    }

    public void setConclude(String Conclude) {
        this.Conclude = Conclude;
    }
    
    
    
}
