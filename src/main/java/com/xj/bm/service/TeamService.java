package com.xj.bm.service;

import com.xj.bm.model.pojo.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xj.bm.model.pojo.User;
import com.xj.bm.model.dto.TeamQuery;
import com.xj.bm.model.dto.TeamJoinRequest;
import com.xj.bm.model.dto.TeamQuitRequest;
import com.xj.bm.model.dto.TeamUpdateRequest;
import com.xj.bm.model.vo.TeamUserVO;

import java.util.List;

/**
* @author ch
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2025-04-19 20:54:09
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    public long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
