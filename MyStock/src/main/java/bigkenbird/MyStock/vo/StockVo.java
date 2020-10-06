package bigkenbird.MyStock.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Stocks")
public class StockVo {

	public StockVo(String stocksymbol, String component, Integer price,Date updatetime) {
		super();
		this.stocksymbol = stocksymbol;
		this.component = component;
		this.price = price;
		this.updatetime=updatetime;
	}


	public StockVo() {
		super();
		
	}


	@Id
	@Column(name="stocksymbol")
	private String stocksymbol;
	
	@Column(name="component")
	private String component;
	

	@Column(name="price")
	private Integer price;
	
	@Column(name="updatetime")
	private Date updatetime;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="stockVo")
	private List<TransactionVo> transactions;

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


	public List<TransactionVo> getTransactions() {
		return transactions;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
