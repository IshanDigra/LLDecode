package LLD_Problems.EASY.CoffeeVendingMachine;

public class CoffeeVendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vm = VendingMachine.getInstance();

        vm.displayMenu();

        COFFEE espresso = vm.selectCoffee("Espresso");
        vm.dispenseCoffee(espresso, 3);

        COFFEE cappuccino = vm.selectCoffee("Cappuccino");



        COFFEE latte = vm.selectCoffee("Latte");
        vm.dispenseCoffee(latte, 20);

        COFFEE latte2 = vm.selectCoffee("Latte");
        vm.dispenseCoffee(latte2, 20);
        COFFEE latte3 = vm.selectCoffee("Latte");
        vm.dispenseCoffee(latte3, 20);
    }
}
