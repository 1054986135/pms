package com.zs.pms.dao;
/**
 * 用户数据操作对象
 * 通用模板8个方法
 * @author Administrator
 *
 */
import java.util.List;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.UserQuery;

public interface UserDao {
//	新增，返回主键
	public void insert(TUser user);
//	修改
	public void update(TUser user);
//	删除一条
	public void delete(int id);
//	根据id查询
	public TUser queryById(int id);
//  根据查询条件查询，不反回关联
	public List<TUser> queryByCon(UserQuery query);
//	分页查询，返回关联对象
	public List<TUser> queryByPage(UserQuery query);
//	删除多条
	public void deletes(int[] ids);
//	查询条数
	public int queryCount(UserQuery query);
	
}
