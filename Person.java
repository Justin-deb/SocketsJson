import java.io.Serializable;

public record Person(int ID, String name, int age, String address) implements Serializable{
    @Override
    public String toString(){
        return String.format("User: %s is %s years old lives in %s and has an ID of: %s", name(),age(),address(),ID());
    }
}