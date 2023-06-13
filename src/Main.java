import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};

        System.out.println("Cписок возможных товаров для покупки");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "." + products[i] + " " + prices[i] + " руб/шт");
        }

        Scanner scanner = new Scanner(System.in);

        int[] productsInBasket = new int[prices.length];// кол- во  введеных товаров
        int[] costOfProduсts = new int[prices.length];// цена товара * кол-во
        int totalSum = 0;// общая сумма корзины

        while (true) {

            System.out.println("Выберите товар и количество или введите `end`");
            String inputSting = scanner.nextLine();
            if (inputSting.equals("end")) {
                break;
            }
            String[] clientChoice = inputSting.split(" ");
            if (clientChoice.length == 1 || clientChoice.length > 2) {
                System.out.println("Надо вводить два значения (номер продукта и количество)!");
                continue;
            }
            try {
                int productNumber = Integer.parseInt(clientChoice[0]) - 1;//номер продукта
                if (productNumber >= products.length || productNumber < 0) {
                    System.out.println("Такого номера продукта нет, смотри внимательней");
                    continue;
                }
                int productCount = Integer.parseInt(clientChoice[1]);// кол-во продукта
                if (productCount <= 0) {
                    System.out.println("Количество товара не может быть отрицательным или равным нулю");
                    continue;
                }

                int currentPrice = prices[productNumber];//текущая цена продукта
                int sumProducts = currentPrice * productCount;// сумма выбранных продуктов

                productsInBasket[productNumber] += productCount;// увеличиваем кол-во товара
                costOfProduсts[productNumber] += sumProducts;// увеличиваем суммы товаров
                totalSum += sumProducts;// Итоговая корзина\
            } catch (NumberFormatException exception) {
                System.out.println("Можно вводить только числа");
            }
            continue;
        }
        System.out.println("Ваша корзина: ");
        for (int i = 0; i < productsInBasket.length; i++) {
            if (productsInBasket[i] == 0) {
                continue;
            }
            System.out.println(products[i] + " " + productsInBasket[i] + " шт " + prices[i] + " руб/шт " + costOfProduсts[i] + " рублей в сумме");
        }
        System.out.println("Итого: " + totalSum + " руб");
    }
}
