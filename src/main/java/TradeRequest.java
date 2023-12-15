import java.math.BigDecimal;

public class TradeRequest {
    private int amount; // кол-во товара
    private BigDecimal total; // полная стоимость
    private int validScale = 2;

    public static void main(String[] args) {
        TradeRequest trade1 = new TradeRequest(100, "1000.02");
        TradeRequest trade2 = new TradeRequest(100, "1000.021");
        TradeRequest trade3 = new TradeRequest(0, "1000.02");
        TradeRequest trade4 = new TradeRequest(100, "0");
        trade1.registerTrade();
        trade2.registerTrade();
        trade3.registerTrade();
        trade4.registerTrade();
    }

    public TradeRequest(int amount, String total) {
        this.amount = amount;
        this.total = new BigDecimal(total);
    }

    public void registerTrade() {
        try {
            validate(amount, total, total.scale());
            System.out.println("Trade registered with total price = " + total + " for amount = " + amount);
        } catch (InvalidAmountException | InvalidTotalException | InvalidTotalScaleException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }

    public void validate(int amount, BigDecimal total, int scale) throws InvalidAmountException, InvalidTotalException, InvalidTotalScaleException {
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        if (total.doubleValue() <= 0) {
            throw new InvalidTotalException();
        }
        if (scale > 2) {
            throw new InvalidTotalScaleException(scale, validScale);
        }
    }
}
