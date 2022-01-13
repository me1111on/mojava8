package chap1;

public class Apple {

    private int weight = 0;
    private String color = "";

    public Apple(int w, String c){
        this.weight = w;
        this.color = c;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
