---
sessionId: session-260919-163945-18k0
---

# Requirements

### Overview & Goals
Впровадження функції пошуку товарів за назвою або категорією з підтримкою неточного регістронезалежного пошуку (`ilike`) на базі Java Stream API у консольному додатку інтернет-магазину (`lesson_1`).

### Scope
- **In Scope**:
  - Створення класу `ProductCatalog` для збереження списку доступних товарів та управління каталогом.
  - Реалізація методів пошуку за допомогою Java Stream API:
    - `getProductsByName(String query)`: пошук за назвою товару.
    - `getProductsByCategory(String query)`: пошук за назвою категорії.
    - `searchProducts(String query)`: універсальний пошук за назвою товару або категорією.
  - Підтримка неточного пошуку за підрядком без урахування регістру (`toLowerCase().contains(...)`).
  - Додавання пункту меню `7 - Пошук товарів` у `Main.java` та обробка відображення результатів пошуку.
- **Out of Scope**:
  - Інтеграція зі сторонніми СУБД або зовнішніми пошуковими рушіями.

### Functional Requirements
1. **Пошук за назвою**: повернення списку всіх товарів, чия назва містить введений підрядок (без урахування регістру).
2. **Пошук за категорією**: повернення списку всіх товарів, назва категорії яких містить введений підрядок.
3. **Універсальний пошук**: метод `searchProducts`, що фільтрує товари за збігом у назві або назві категорії.
4. **Інтеграція в консольне меню**: виведення списку знайдених товарів або сповіщення "Товарів не знайдено".

# Technical Design

### Proposed Changes
1. **`ProductCatalog.java`**:
   - Поле `private List<Product> products` для інкапсуляції товарів магазину.
   - Конструктор `public ProductCatalog()` та методи `addProduct(Product product)`, `getAllProducts()`.
   - Метод `getProductsByName(String query)`: фільтрація через `products.stream().filter(...).toList()`.
   - Метод `getProductsByCategory(String query)`: фільтрація через `products.stream().filter(...).toList()`.
   - Метод `searchProducts(String query)`: фільтрація через `products.stream().filter(...).toList()`.
   - Безпечна валідація вхідних даних на `null` та `isBlank()`.
2. **`Main.java`**:
   - Ініціалізація `ProductCatalog catalog = new ProductCatalog();` та додавання початкових товарів (`product1`, `product2`, `product3`).
   - Додавання пункту меню `7 - Пошук товарів`.
   - Обробник `case 7` у циклі меню зі зчитуванням рядка пошуку та виведенням результатів `catalog.searchProducts(query)`.

# Delivery Steps

### ✓ Step 1: Створення класу ProductCatalog з використанням Java Stream API
Реал��зація моделі каталогу та алгоритмів фільтрації:
- Створити файл `src/main/java/lesson_1/ProductCatalog.java`.
- Реалізувати інкапсуляцію списку `products`, методи `addProduct`, `getAllProducts`.
- Реалізувати методи `getProductsByName`, `getProductsByCategory` та `searchProducts` за допомогою декларативних фільтрів Java Stream API.

### ✓ Step 2: Інтеграція пошуку в Main.java
Підключення каталогу товарів та налаштування інтерфейсу користувача в консолі:
- Ініціалізувати екземпляр `ProductCatalog` у `Main.java` та зареєструвати початкові товари.
- Оновити меню `Main.java`, додавши пункт `7 - Пошук товарів`.
- Реалізувати обробник `case 7` для зчитування пошукового запиту, виклику `searchProducts` та виведення списку знайдених товарів.