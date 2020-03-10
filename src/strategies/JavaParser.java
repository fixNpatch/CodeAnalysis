package strategies;

public class JavaParser implements IParser {

    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void parse() {
        System.out.println("IParser == JavaParser");
    }
}
