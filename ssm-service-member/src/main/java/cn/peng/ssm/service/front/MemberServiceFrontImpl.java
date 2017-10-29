package cn.peng.ssm.service.front;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.peng.ssm.dao.IActionDAO;
import cn.peng.ssm.dao.IMemberDAO;
import cn.peng.ssm.dao.IRoleDAO;
import cn.peng.ssm.vo.Member;

@Service
public class MemberServiceFrontImpl implements IMemberServiceFront {
	@Resource 
	private IMemberDAO memberDAO;
	@Resource 
	private IRoleDAO roleDAO;
	@Resource 
	private IActionDAO actionDAO;
	
	@Override
	public Member get(String mid) {
		return this.memberDAO.findById(mid);
	}
	@Override
	public Map<String, Set<String>> getRoleAndActionByMember(String mid) {
		Map<String, Set<String>> map = new HashMap<>();
		map.put("allRoles", this.roleDAO.findAllByMember(mid));
		map.put("allActions", this.actionDAO.findAllByMember(mid));
		return map;
	}
}
