public class Thing {
    private int volume;
    private String name;

    public Thing(int volume) {
        this.volume = volume;
        this.name = "";
    }

    public Thing(int volume, String name) {
        this.volume = volume;
        this.name = name;
    }

    public int volume() {
        return volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasName(String n) {
        return this.name.equals(n);
    }

    @Override
    public String toString() {
        return name;
    }
}
