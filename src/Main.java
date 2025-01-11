import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   private static ArrayList<Item> items = new ArrayList<>();
   private static int idCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("옵션을 선택하세요");
            System.out.println("1. 아이템 생성");
            System.out.println("2. 아이템 확인");
            System.out.println("3. 아이템 업데이트");
            System.out.println("4. 아이템 삭제");
            System.out.println("5. 나가기");
            int choice = scanner.nextInt();
            scanner.nextLine()

                    switch (choice) {
                case 1 -> createItem(scanner);
                case 2 -> readItems();
                case 3 -> updateItem(scanner);
                case 4 -> deleteItem(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                        default -> System.out.println("유효하지 않은 옵션입니다. 다시 시도해주세요.");
                    }
        }
    }
    private static void createItem(Scanner scanner) {
        System.out.println("아이템 이름을 입력하세요 : ");
        String name = scanner.nextLine();
        items.add(new Item(idCounter++, name));
        System.out.println("아이템이 성공적으로 생성되었습니다. ");
    }

    private static void readItems() {
        if (items.isEmpty()) {
            System.out.println("아이템을 찾을 수 없습니다.");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }
    private static void updateItem(Scanner scanner) {
        System.out.println("업데이트 할 아이템 ID를 입력해주세요. ");
        int id = scanner.nextInt();
        scanner.nextLine()
                for(Item item : items) {
                    if (item.getId() == id) {
                        System.out.println("새로운 이름을 입력해주세요");
                        String name = scanner.nextLine();
                        item.setName(name);
                        System.out.println("아이템 업데이트가 성공적으로 되었습니다.");
                        return;

                    }
                }
        System.out.println("아이템을 찾을수 없습니다. ");
    }

}