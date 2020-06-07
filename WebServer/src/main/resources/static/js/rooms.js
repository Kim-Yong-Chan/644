function getRoomList(){
    $.ajax({
        type:"GET",
        url : "http://192.168.43.70:8100/RoomList",
        accept : "application/json",
        contentType : "application/json",
        dataType : 'text',
    })
}

function refreshRoomList(){
    document.location.href = 'http://192.168.43.70:8100/RoomList';
}

function refreshBoardList(roomId){
    document.location.href = 'http://192.168.43.70:8100/PostsList/'+roomId;
    console.log("activated " + roomId);
}
$(document).ready(getRoomList());