---
sessionId: session-260919-163945-18k0
---

# Requirements

### Overview & Goals
Реалізація функціоналу видалення товарів з кошика (`Cart`) у консольному додатку інтернет-магазину (`lesson_1`) за обраним Варіантом 3 (використання методу `removeProduct(Product product)` з поверненням `boolean`).

### Scope
- **In Scope**:
  - Оновлення методу `removeProduct(Product product)` у `Cart.java` для повернення булевого статусу операції.
  - Оновлення консольного меню в `Main.java`: додавання опції `5 - Видалити товар з кошика`.
  - Реалізація `case 5` у циклі `Main.java` з перевіркою наявності товарів у кошику, зіставленням введеного `ID` з об'єктом товару та обробкою статусів видалення.
- **Out of Scope**:
  - Додаткова зміна структури класів або збереження даних у зовнішні джерела.

### Functional Requirements
1. **Відображення пункту меню**: Меню в `Main.java` містить пункт `5 - Видалити товар з кошика`.
2. **Перевірка порожнього кошика**: Якщо користувач вибирає пункт 5 при порожньому кошику, виводиться повідомлення `"Кошик порожній."`.
3. **Зіставлення товару**: За введеним числовим `ID` (1, 2 або 3) визначається цільовий об'єкт товару (`Product`).
4. **Зворотний зв'язок**:
   - Якщо `ID` не існує в каталозі: `"Товар з таким ID не знайдено."`.
   - Якщо товар успішно видалено: `"Товар успішно видалено з кошика!"`.
   - Якщо такого товару не було в кошику: `"Цього товару немає у вашому кошику."`.

# Technical Design

### Current Implementation
- `Cart.java` містить `public void removeProduct(Product product) { products.remove(product); }` (ігнорує повернене значення `boolean`).
- `Main.java` не має пункту 5 у виводі меню та відповідного блоку `case 5` у `switch (choice)`.

### Key Decisions
- **Сигнатура `removeProduct`**: Зміна сигнатури на `public boolean removeProduct(Product product)` замість створення окремого методу `removeProductById`. Це відповідає умовам завдання та дозволяє викликати стандартний `products.remove(product)`.
- **Логіка `Main.java`**: Отримання `removeId` через `scanner.nextInt()`, вибір відповідного екземпляра `product1`, `product2` або `product3`, виклик `cart.removeProduct(...)` і виведення відповідного статусу.

### Proposed Changes
1. **`Cart.java`**:
   ```java
   public boolean removeProduct(Product product) {
       return products.remove(product);
   }
   ```
2. **`Main.java`**:
   - Додати вивід рядка `System.out.println("5 - Видалити товар з кошика");`.
   - Додати обробку `case 5`:
     - Перевірка `cart.getProducts().isEmpty()`.
     - Зчитування `int removeId = scanner.nextInt()`.
     - Визначення цільового об'єкта `Product toRemove`.
     - Виклик `cart.removeProduct(toRemove)` з виведенням повідомлення про результат.

# Delivery Steps

### ✓ Step 1: Оновлення методу видалення в Cart.java
Зміна типу повернення методу `removeProduct` на `boolean`:
- Відкрити `src/main/java/lesson_1/Cart.java`.
- Оновити метод `public boolean removeProduct(Product product) { return products.remove(product); }`.

### ✓ Step 2: Оновлення консольного меню та обробника в Main.java
Додавання опції видалення та обробки вибору користувача:
- Оновити меню в `src/main/java/lesson_1/Main.java`, додавши рядок `5 - Видалити товар з кошика`.
- Реалізувати блок `case 5` з валідацією порожнього кошика, пошуком об'єкта товару за `ID`, викликом `cart.removeProduct()` та виведенням результату.