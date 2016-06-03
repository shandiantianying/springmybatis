package cn.shandian.tianying.inter;

import java.util.List;

import cn.shandian.tianying.User.Article;
import cn.shandian.tianying.User.User;

public interface IUser {
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public void addUser(User user);

	public List<Article> getUserArticles(int userid);
}
