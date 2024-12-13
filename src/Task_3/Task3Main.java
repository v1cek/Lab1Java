import java.util.*;
import java.util.Optional;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

public class Task3Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice"));
        users.add(new User(2, "Bob"));
        users.add(new User(3, "Charlie"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ID користувача для пошуку:");
        int userId = scanner.nextInt();

        Optional<User> user = findUserById(users, userId);

        user.ifPresentOrElse(
                u -> System.out.println("Користувач знайдений: " + u),
                () -> System.out.println("Користувача з ID " + userId + " не знайдено.")
        );

        scanner.close();
    }

    public static Optional<User> findUserById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }
}
