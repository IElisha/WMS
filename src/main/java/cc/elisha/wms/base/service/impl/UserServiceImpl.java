package cc.elisha.wms.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.elisha.wms.base.domain.User;
import cc.elisha.wms.base.mapper.UserMapper;
import cc.elisha.wms.base.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void save(User user) {
		this.userMapper.insert(user);
	}

	@Override
	public void delete(Long id) {
		this.userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(User user) {
		this.userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User get(Long id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> listAll() {
		return this.userMapper.selectAll();
	}

}
