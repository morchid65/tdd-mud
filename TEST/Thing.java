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
        return this.name != null && this.name.equals(n);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing)) return false;
        Thing other = (Thing) o;
        if (name == null) return other.name == null && volume == other.volume;
        return name.equals(other.name) && volume == other.volume;
    }

    @Override
    public int hashCode() {
        int result = (name == null) ? 0 : name.hashCode();
        result = 31 * result + volume;
        return result;
    }
}