import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Task2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Крок 1: Отримати текст від користувача або з файлу
        System.out.println("Введіть текст вручну або шлях до файлу:");
        String input = scanner.nextLine();

        String text;
        if (Files.exists(Path.of(input))) {
            try {
                text = Files.readString(Path.of(input));
            } catch (IOException e) {
                System.out.println("Не вдалося зчитати файл. Перевірте шлях і спробуйте знову.");
                return;
            }
        } else {
            text = input;
        }

        System.out.println("Текст для аналізу: \n" + text);

        while (true) {
            // Крок 2: Меню вибору операцій
            System.out.println("\nВиберіть операцію:");
            System.out.println("1 - Розбиття тексту на слова");
            System.out.println("2 - Фільтрація слів, що починаються з певної літери");
            System.out.println("3 - Сортування слів за алфавітом");
            System.out.println("4 - Підрахунок кількості унікальних слів");
            System.out.println("5 - Вихід");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистити буфер

            if (choice == 5) {
                System.out.println("Вихід з програми.");
                break;
            }

            switch (choice) {
                case 1 -> {
                    // Розбиття тексту на слова
                    List<String> words = Arrays.stream(text.split("\\s+"))
                            .collect(Collectors.toList());
                    System.out.println("Слова: " + words);
                }
                case 2 -> {
                    // Фільтрація слів за першою літерою
                    System.out.println("Введіть першу літеру:");
                    String letter = scanner.nextLine();
                    List<String> filteredWords = Arrays.stream(text.split("\\s+"))
                            .filter(word -> word.startsWith(letter))
                            .collect(Collectors.toList());
                    System.out.println("Відфільтровані слова: " + filteredWords);
                }
                case 3 -> {
                    // Сортування слів за алфавітом
                    List<String> sortedWords = Arrays.stream(text.split("\\s+"))
                            .sorted()
                            .collect(Collectors.toList());
                    System.out.println("Відсортовані слова: " + sortedWords);
                }
                case 4 -> {
                    // Підрахунок унікальних слів
                    long uniqueWordCount = Arrays.stream(text.split("\\s+"))
                            .distinct()
                            .count();
                    System.out.println("Кількість унікальних слів: " + uniqueWordCount);
                }
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
