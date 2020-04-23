package com.teamViewer.roomserver.services;

import java.util.List;

import com.teamViewer.roomserver.Exception.NoDataException;
import com.teamViewer.roomserver.Model.Request.CreateRoomRequest;
import com.teamViewer.roomserver.Model.Request.RoomListRequest;
import com.teamViewer.roomserver.Model.Request.UserEnterRequest;
import com.teamViewer.roomserver.Model.Request.UserExitRequest;
import com.teamViewer.roomserver.Model.RoomModel;
import com.teamViewer.roomserver.repository.RoomRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*Service의 역할은 Dao가 DB에서 받아온 데이터를 전달받아 가공하는 것*/
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void enterUser(UserEnterRequest joinRequestModel){
        RoomModel roomModel = new RoomModel(joinRequestModel.getRoomId(), joinRequestModel.getUserId(), joinRequestModel.getName());
        roomRepository.save(roomModel);
    }
    public void exitUser(UserExitRequest exitRequestModel) throws NoDataException{
        roomRepository.delete(roomRepository.findByRoomIdAndUserId(exitRequestModel.getRoomId(), exitRequestModel.getUserId()).orElseThrow(NoDataException::new));
    }
    public List getRoomList(String userId) throws NoDataException{
        return roomRepository.findAllByUserId(userId).orElseThrow(NoDataException::new);
    }
    public List getUserList(String roomId) throws NoDataException {
        return roomRepository.findAllByRoomId(roomId).orElseThrow(NoDataException::new);
    }



    public String createRoom(String userId, String name) {
        //roomId생성하고(중복허용 X) roomRequestModel의 userId와 roomName을 더해서 테이블에 튜플 추가하고 id 리턴

        //난수생성
        int roomId = (int) Math.random();
        String roomIdString = Integer.toString(roomId);

        while(roomRepository.findByRoomId(roomIdString).isPresent()) {
            roomId = (int) Math.random();
            roomIdString = Integer.toString(roomId);
        }

        RoomModel newRoom = new RoomModel(roomIdString, userId, name);
        roomRepository.save(newRoom);
        return "성공";
    }

}
