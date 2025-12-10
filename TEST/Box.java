import java.util.ArrayList;

public class Box {
    private ArrayList<Thing> contents = new ArrayList<>();
    private boolean open;
    private int capacity; // -1 = unlimited
    private int used;

    public Box() {
        this.open = true;
        this.capacity = -1;
        this.used = 0;
    }

    public Box(boolean open, int capacity) {
        this.open = open;
        this.capacity = capacity;
        this.used = 0;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

    public void add(Thing t) {
        contents.add(t);
    }

    public boolean contains(Thing t) {
        return contents.contains(t);
    }

    public void remove(Thing t) throws Exception {
        if (!contents.contains(t)) {
            throw new Exception("Objet non présent");
        }
        contents.remove(t);
        used -= t.volume();
        if (used < 0) used = 0;
    }

    public String actionLook() {
        if (!open) return "la boite est fermee";
        if (contents.isEmpty()) return "la boite est vide";
        // construire "ceci, cela" à partir des toString() des éléments
        String[] names = contents.stream().map(Object::toString).toArray(String[]::new);
        return "la boite contient: " + String.join(", ", names);
    }

    public void setCapacity(int c) {
        this.capacity = c;
    }

    public int capacity() {
        return capacity;
    }

    public boolean hasRoomFor(Thing t) {
        return capacity == -1 || used + t.volume() <= capacity;
    }

    public void actionAdd(Thing t) throws Exception {
        if (!open) throw new Exception("Boite fermée");
        if (!hasRoomFor(t)) throw new Exception("Pas assez de place");
        contents.add(t);
        used += t.volume();
    }

    public Thing find(String name) throws Exception {
        if (!open) throw new Exception("Boite fermée");
        for (Thing t : contents) {
            if (t.hasName(name)) return t;
        }
        throw new Exception("Objet non trouvé");
    }

    @Override
    public String toString() {
        return actionLook();
    }
}