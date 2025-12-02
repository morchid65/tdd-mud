import java.util.ArrayList;

class Thing {
    String name;

    public Thing(String name) {
        this.name = name;
    }
}
class Box{

    ArrayList<String> contents = new ArrayList<String>();

  public void add(String truc) {
    this.contents.add(truc);
}
}