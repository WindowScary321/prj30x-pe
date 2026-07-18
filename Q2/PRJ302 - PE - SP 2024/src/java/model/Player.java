package model;

public class Player {
    private int Code;
    private String Name;
    private String Position;
    private double Salary;

    public Player() {
    }

    public Player(int Code, String Name, String Position, double Salary) {
        this.Code = Code;
        this.Name = Name;
        this.Position = Position;
        this.Salary = Salary;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
    
}
