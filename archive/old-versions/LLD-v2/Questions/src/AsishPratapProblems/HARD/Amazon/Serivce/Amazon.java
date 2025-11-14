package AsishPratapProblems.HARD.Amazon.Serivce;

public class Amazon {
    private static Amazon instance;
    private final CartService cartService;
    private final OrderService orderService;
    private final ProductService productService;

    private Amazon() {
        cartService = new CartService();
        orderService = new OrderService();
        productService = new ProductService();
    }

    public synchronized  static Amazon getInstance(){
        if(instance==null){
            instance= new Amazon();
        }
        return instance;
    }


}
