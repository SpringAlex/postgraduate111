package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.InvitationMapper;
import com.example.postgraduate.POJO.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationServiceIml implements InvitationService{
    @Autowired
    InvitationMapper invitationMapper;

    @Override
    public boolean post(Invitation invitation) {
        return invitationMapper.post(invitation);
    }

    @Override
    public boolean changeStatus(Integer invitation_id, Integer invitation_status) {
        return invitationMapper.changeStatus(invitation_id,invitation_status);
    }

    @Override
    public boolean addScan(Integer invitation_id) {
        return invitationMapper.addScan(invitation_id);
    }

    @Override
    public List<Invitation> getHotInvitation() {
        return invitationMapper.getHotInvitation();
    }

    @Override
    public List<Invitation> getInvitation() {
        return invitationMapper.getInvitation();
    }

    @Override
    public List<Invitation> getPlateInvitation(Integer plate) {
        return invitationMapper.getPlateInvitation(plate);
    }

    @Override
    public List<Invitation> queryInvitation(String condition) {
        return invitationMapper.queryInvitation(condition);
    }

}
