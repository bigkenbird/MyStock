package bigkenbird.MyStock.vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class TransactionVo {
	
	public TransactionVo() {
		super();
	}
	
	public TransactionVo(UserVo userVo, StockVo stockVo, String trans_type, Integer shares_num, Integer trans_income,
			Date trans_time) {
		super();
		this.userVo = userVo;
		this.stockVo = stockVo;
		this.trans_type = trans_type;
		this.shares_num = shares_num;
		this.trans_income = trans_income;
		this.trans_time = trans_time;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transactionid")
	private String transactionid;
	
	@ManyToOne
	@JoinColumn(name="userid") //使用者代號
	private UserVo userVo;
	
	@ManyToOne
	@JoinColumn(name="stocksymbol") //股票代號
	private StockVo stockVo;
	
	@Column(name="trans_type") //買或賣
	private String trans_type;
	
	@Column(name="shares_num")
	private Integer shares_num; //股份
	
	@Column(name="trans_income")
	private Integer trans_income; //獲益
	
	@Column(name="trans_time") //交易時間
	private Date trans_time;

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public Integer getShares_num() {
		return shares_num;
	}

	public void setShares_num(Integer shares_num) {
		this.shares_num = shares_num;
	}

	public Integer getTrans_income() {
		return trans_income;
	}

	public void setTrans_income(Integer trans_income) {
		this.trans_income = trans_income;
	}

	public Date getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(Date trans_time) {
		this.trans_time = trans_time;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public StockVo getStockVo() {
		return stockVo;
	}
	
}
