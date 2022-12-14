package com.sm.expose.frame.respository;


import com.sm.expose.frame.domain.FrameUser;

import java.util.List;

public interface FrameUserRepositoryCustom {
    FrameUser findByFrameUser(Long frameId, Long userId);
    List<FrameUser> findByUser(Long userId);

}
