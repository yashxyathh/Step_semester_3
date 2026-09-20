public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int maximumItems) {
        this.cartId = cartId;
        itemPrices = new double[maximumItems];
    }

    public void addItem(double price) {
        if (itemCount < itemPrices.length) {
            itemPrices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}
