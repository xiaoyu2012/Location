package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
		/**
		 * 用户id,自增型
		 */
		@Id @Column(name="admin_id")   //用户id,自增型
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer adminId;
		
		/**
		 * 管理员姓名
		 */
		@Column(name="adminname", nullable=false)  	//用户名
		private String adminName;	
		
		/**
		 * 用户密码
		 */
		@Column(name="password" , nullable=false)	//用户密码
		private String password;

		public Integer getAdminId() {
			return adminId;
		}

		public void setAdminId(Integer adminId) {
			this.adminId = adminId;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
}
