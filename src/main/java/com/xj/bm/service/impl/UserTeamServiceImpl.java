package com.xj.bm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xj.bm.model.pojo.UserTeam;
import com.xj.bm.service.UserTeamService;
import com.xj.bm.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author ch
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2025-04-19 20:54:09
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




