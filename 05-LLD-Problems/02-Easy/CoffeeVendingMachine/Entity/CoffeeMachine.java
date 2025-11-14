package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState.DispenseState;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState.IdleState;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState.MachineState;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState.TransactionState;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CoffeeType;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.Ingredient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CoffeeMachine implements MachineState {
    private static CoffeeMachine machine;
    private Inventory inventory;
    private MachineState idleState;
    private MachineState transactionState;
    private MachineState dispenseState;
    private MachineState currentState;
    private Map<CoffeeType, Coffee> coffees;
    private Coffee selectedCoffee;
    private double total;

    private CoffeeMachine() {
        inventory = new Inventory();
        coffees = new ConcurrentHashMap<>();
        selectedCoffee = null;
        total = 0.0;
        initializeMachine();
        idleState = new IdleState(this);
        transactionState = new TransactionState(this);
        dispenseState = new DispenseState(this);
        currentState = idleState;
        initializeMachine();
        displayMenu();
    }

    private void initializeMachine(){
        restockInventory(Ingredient.COFFEE, 2);
        restockInventory(Ingredient.MILK, 2);
        restockInventory(Ingredient.SUGAR, 2);
        restockInventory(Ingredient.WATER, 2);

        Coffee c1 = new Coffee("Cappuchino", CoffeeType.CAPPUCCINO, new Recipe(Map.of(Ingredient.COFFEE,2, Ingredient.MILK,2,Ingredient.SUGAR,2)),20.0);
        Coffee c2 = new Coffee("Latte", CoffeeType.LATTE, new Recipe(Map.of(Ingredient.COFFEE,2, Ingredient.MILK,2,Ingredient.SUGAR,2)),40.0);
        coffees.put(c1.getType(),c1);
        coffees.put(c2.getType(),c2);
    }

    public void restockInventory(Ingredient ingredient, int quantity){
        inventory.restockIngredients(ingredient, quantity);
    }
    public void displayMenu(){
        coffees.entrySet().stream().forEach(r-> System.out.println(r.getKey() + ": "+r.getValue().getPrice()));
    }
    public static synchronized CoffeeMachine getInstance(){
        if(machine == null){
            machine = new CoffeeMachine();
        }
        return machine;
    }


    @Override
    public void selectCoffee(CoffeeType coffee) {
        Recipe recipe = coffees.get(coffee).getRecipe();
        if(!inventory.isAvailable(recipe)){
            return ;
        }
        currentState.selectCoffee(coffee);
    }

    @Override
    public void addCash(Cash cash, int quantity) {
        currentState.addCash(cash, quantity);
    }

    @Override
    public void makePayment() {
        currentState.makePayment();
    }


    @Override
    public void dispenseCoffee() {
        currentState.dispenseCoffee();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public void setIdleState(MachineState idleState) {
        this.idleState = idleState;
    }

    public MachineState getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(MachineState transactionState) {
        this.transactionState = transactionState;
    }

    public MachineState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(MachineState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public Map<CoffeeType, Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Map<CoffeeType, Coffee> coffees) {
        this.coffees = coffees;
    }

    public Coffee getSelectedCoffee() {
        return selectedCoffee;
    }

    public void setSelectedCoffee(Coffee selectedCoffee) {
        this.selectedCoffee = selectedCoffee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
