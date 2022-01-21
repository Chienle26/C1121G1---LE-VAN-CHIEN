package ss15_io_text_file.excercise.read_file_csv;

public class Country {
    private String numbericalOrder;
    private String symbol;
    private String contry;

    public Country() {
    }

    public Country(String numbericalOrder, String symbol, String contry) {
        this.numbericalOrder = numbericalOrder;
        this.symbol = symbol;
        this.contry = contry;
    }

    public String getNumbericalOrder() {
        return numbericalOrder;
    }

    public void setNumbericalOrder(String numbericalOrder) {
        this.numbericalOrder = numbericalOrder;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }
}
