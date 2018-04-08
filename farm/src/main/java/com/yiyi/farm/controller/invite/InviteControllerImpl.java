package com.yiyi.farm.controller.invite;

import com.yiyi.farm.entity.invite.InviteRelationEntity;
import com.yiyi.farm.facade.invite.InviteService;
import com.yiyi.farm.req.invite.InviteReq;
import com.yiyi.farm.rsp.Result;
import com.yiyi.farm.tool.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Stream;

@RestController
public class InviteControllerImpl implements InviteController {
    ThreadPoolExecutor singlePool = new ThreadPoolExecutor(1,1,0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    @Autowired
    private InviteService inviteService;

    @Override
    public Result handleInit() {
        singlePool.execute(() -> inviteService.init());

        return Result.newSuccessResult();
    }

    @Override
    public Result handleFindChildByPhone(InviteReq invite) {
        String[] phones = invite.getPhone();
        Queue<InviteRelationEntity> list = inviteService.findChildByPhone(phones[0]);
        return Result.newSuccessResult(list);
    }

    @Override
    public Result handleFindChildNumberByPhone(InviteReq invite) {
        String[] phones = invite.getPhone();
        Map<String, Pair> map = new ConcurrentHashMap<>();
        Stream.of(phones).parallel().forEach(phone -> map.put(phone, inviteService.findChildNumbersByPhone(phone)));
        System.out.println(map);
        return Result.newSuccessResult(map);
    }

    @Override
    public Result handleFindChildByUid(InviteReq invite) {
        String[] uids = invite.getUid();
        Queue<InviteRelationEntity> list = inviteService.findChildByUid(uids[0]);
        return Result.newSuccessResult(list);
    }

}
