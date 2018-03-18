package action;

public class CheckoutProcess extends AbstractProcess {

    @Override
    protected void action(Orderable item) {
        System.out.println("Checkout process");
        item.pay();
    }
}
