package action;

public class PaymentProcess extends AbstractProcess {

    @Override
    protected void action(Orderable item) {
        System.out.println("Payment process");
        item.checkout();
    }
}
