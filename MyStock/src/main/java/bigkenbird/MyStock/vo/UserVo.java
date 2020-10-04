package bigkenbird.MyStock.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserVo {
	
	public UserVo() {
		
	}
	
	
	public UserVo(String account, String password, String name, Integer money) {
		this.account = account;
		this.password = password;
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
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="money")
	private Integer money;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}
