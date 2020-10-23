package bigkenbird.MyStock.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserVo {
	
	public UserVo() {
		
	}
	
	
	public UserVo(String account, byte[] decrypted_password, String name, Integer money) {
		this.account = account;
		this.decrypted_password = decrypted_password;
		this.name = name;
		this.money = money;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private byte[] decrypted_password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="money")
	private Integer money;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="userVo")
	private List<TransactionVo> transactions;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public byte[] getPassword() {
		return decrypted_password;
	}

	public void setdecrypted_password(byte[] decrypted_password) {
		this.decrypted_password = decrypted_password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
	
	public String getEntityName() {
		return "Users";
	}


	public List<TransactionVo> getTransactions() {
		return transactions;
	}
}
