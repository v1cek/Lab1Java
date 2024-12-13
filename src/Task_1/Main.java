import java.util.Scanner;

// Функціональний інтерфейс для операцій над текстом
@FunctionalInterface
interface TextOperation {
    String execute(String text, String argument);
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Крок 1: Отримуємо текст від користувача
        System.out.println("Введіть текст:");
        String text = scanner.nextLine();

        while (true) {
            // Крок 2: Меню вибору операцій
            System.out.println("\nВиберіть операцію:");
            System.out.println("1 - Пошук слова");
            System.out.println("2 - Замінити слово");
            System.out.println("3 - Підрахунок кількості слів");
            System.out.println("4 - Вихід");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистити буфер

            if (choice == 4) {
                System.out.println("Вихід з програми.");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Введіть слово для пошуку:");
                    String word = scanner.nextLine();

                    // Лямбда-вираз для пошуку слова
                    TextOperation search = (txt, w) -> txt.contains(w) ? "Слово знайдено!" : "Слово не знайдено!";
                    System.out.println(search.execute(text, word));
                }

                case 2 -> {
                    System.out.println("Введіть слово для заміни:");
                    String wordToReplace = scanner.nextLine();
                    System.out.println("Введіть нове слово:");
                    String newWord = scanner.nextLine();

                    // Лямбда-вираз для заміни слова
                    TextOperation replace = (txt, w) -> txt.replace(w, newWord);
                    text = replace.execute(text, wordToReplace); // Оновлюємо текст після заміни
                    System.out.println("Оновлений текст: " + text);
                }

                case 3 -> {
                    // Лямбда-вираз для підрахунку кількості слів
                    TextOperation wordCount = (txt, arg) -> String.valueOf(txt.split("\\s+").length);
                    System.out.println("Кількість слів: " + wordCount.execute(text, ""));
                }

                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}