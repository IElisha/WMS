package cc.elisha.wms.base.service;

import java.util.List;

import cc.elisha.wms.base.domain.User;

public interface IUserService {
	void save(User user);

	void delete(Long id);

	void update(User user);

	User get(Long id);

	List<User> listAll();

}
