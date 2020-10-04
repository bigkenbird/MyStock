package bigkenbird.MyStock.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stocks")
public class StockVo {

	public StockVo(String stocksymbol, String component, Integer price) {
		super();
		this.stocksymbol = stocksymbol;
		this.component = component;
		this.price = price;
	}


	@Id
	@Column(name="stocksymbol")
	private String stocksymbol;
	
	@Column(name="component")
	private String component;
	
	
	@Column(name="price")
	private Integer price;


	public String getStocksymbol() {
		return stocksymbol;
	}


	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}


	public String getComponent() {
		return component;
	}


	public void setComponent(String component) {
		this.component = component;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}
}
