import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Введите количество удалённых клеток:");
        int cellCount = inputReader.nextInt();
        Set<String> removedCells = new HashSet<>();

        System.out.println("Введите их координаты:");
        // Читаем координаты удалённых клеток и добавляем их в набор
        for (int i = 0; i < cellCount; i++) {
            int xCoord = inputReader.nextInt();
            int yCoord = inputReader.nextInt();
            removedCells.add(xCoord + " " + yCoord);
        }

        // Направления для проверки соседей: вверх, вниз, влево, вправо
        int[][] neighborOffsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int totalPerimeter = 0;

        // Для каждой клетки проверяем наличие соседей
        for (String removedCell : removedCells) {
            String[] coordinates = removedCell.split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            for (int[] offset : neighborOffsets) {
                int neighborX = x + offset[0];
                int neighborY = y + offset[1];

                // Если соседней клетки нет в наборе, это часть периметра
                if (!removedCells.contains(neighborX + " " + neighborY)) {
                    totalPerimeter++;
                }
            }
        }

        System.out.println(totalPerimeter); // Выводим периметр
    }
}
