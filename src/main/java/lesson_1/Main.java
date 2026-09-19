package lesson_1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        OrderHistory history = new OrderHistory();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        history.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear(); // Метод для очищення кошика, який потрібно реалізувати в класі Cart
                    }
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній.");
                        break;
                    }
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    Product toRemove = null;
                    if (removeId == 1) toRemove = product1;
                    else if (removeId == 2) toRemove = product2;
                    else if (removeId == 3) toRemove = product3;

                    if (toRemove == null) {
                        System.out.println("Товар з таким ID не знайдено.");
                    } else if (cart.removeProduct(toRemove)) {
                        System.out.println("Товар успішно видалено з кошика!");
                    } else {
                        System.out.println("Цього товару немає у вашому кошику.");
                    }
                    break;
                case 6:
                    System.out.println(history);
                    break;
                case 7:
                    System.out.println("Введіть пошуковий запит (назва або категорія):");
                    scanner.nextLine();
                    String query = scanner.nextLine();
                    List<Product> searchResults = catalog.searchProducts(query);
                    if (searchResults.isEmpty()) {
                        System.out.println("Товарів не знайдено за запитом: " + query);
                    } else {
                        System.out.println("Знайдені товари:");
                        for (Product product : searchResults) {
                            System.out.println(product);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}
