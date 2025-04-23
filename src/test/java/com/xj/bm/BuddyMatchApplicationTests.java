package com.xj.bm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xj.bm.model.pojo.UserTeam;
import com.xj.bm.model.vo.TeamUserVO;
import com.xj.bm.service.TeamService;
import com.xj.bm.service.UserService;
import com.xj.bm.service.UserTeamService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class BuddyMatchApplicationTests {

	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	@Resource
	private UserService userService;
	@Resource
	private TeamService teamService;
	@Resource
	private UserTeamService userTeamService;

	@Test
	void contextLoads() {
		//redisTemplate.opsForValue().setIfAbsent("lock", "123", Duration.ofHours(1));
		//Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "456", Duration.ofHours(1));
		//Assertions.assertEquals(false,lock);
		//Boolean lock1 = redisTemplate.opsForValue().setIfPresent("lock", "456", Duration.ofHours(1));
		//Assertions.assertEquals(true,lock1);
	}
	@Test
	void testElse(){
		// 1、查询队伍列表
		List<TeamUserVO> teamList = teamService.listTeams(null, true);
		// 队伍的ID列表
		final List<Long> teamIdList = teamList.stream().map(TeamUserVO::getId).collect(Collectors.toList());
		QueryWrapper<UserTeam> userTeamJoinQueryWrapper = new QueryWrapper<>();
		userTeamJoinQueryWrapper.in("teamId", teamIdList);
		List<UserTeam> userTeamList = userTeamService.list(userTeamJoinQueryWrapper);
		// 队伍 id => 加入这个队伍的用户列表
		Map<Long, List<UserTeam>> teamIdUserTeamList = userTeamList.stream().collect(Collectors.groupingBy(UserTeam::getTeamId));
		teamList.forEach(team -> team.setHasJoinNum(teamIdUserTeamList.getOrDefault(team.getId(), new ArrayList<>()).size()));

	}

}
