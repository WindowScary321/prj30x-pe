package entity;

public class Tdee {
    private int Coefficient;
    private int Weight;
    private int Tde;
    private String Conclude;

    public Tdee() {
    }

    public Tdee(int Coefficient, int Weight, int Tde, String Conclude) {
        this.Coefficient = Coefficient;
        this.Weight = Weight;
        this.Tde = Tde;
        this.Conclude = Conclude;
    }

    public int getCoefficient() {
        return Coefficient;
    }

    public void setCoefficient(int Coefficient) {
        this.Coefficient = Coefficient;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    public int getTde() {
        return Tde;
    }

    public void setTde(int Tde) {
        this.Tde = Tde;
    }

    public String getConclude() {
        return Conclude;
    }

    public void setConclude(String Conclude) {
        this.Conclude = Conclude;
    }
    
    
}
