package stockSystem.resultModel;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/12.
 */
public class T_stock_info implements Serializable {
    private String stock_id;
    private String stock_name;

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }
}
