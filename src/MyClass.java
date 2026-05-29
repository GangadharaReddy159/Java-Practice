import java.util.Collections;
import java.util.List;

public final class MyClass {

    private final int id;
    private final String name;
    private List<String> hobbies;

    public MyClass(int id, String name, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.hobbies = Collections.unmodifiableList(hobbies);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
