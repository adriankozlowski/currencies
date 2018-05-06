import java.math.BigDecimal;

public class MyCurrency {
    private String code;
    private String currency;
    private BigDecimal mid;

    public MyCurrency(String code, String currency, BigDecimal mid) {
        this.code = code;
        this.currency = currency;
        this.mid = mid;
    }

    public MyCurrency() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
}
