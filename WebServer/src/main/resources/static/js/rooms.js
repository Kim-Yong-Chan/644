function getRoomList(){
    $.ajax({
        type:"GET",
        url : webserver+"/RoomList",
        accept : "application/json",
        contentType : "application/json",
        dataType : 'text',
    })
}

function refreshRoomList(){
    window.location.href = webserver+"/RoomList";
}

function refreshBoardList(roomId){
    window.location.href = webserver+'/PostsList/'+roomId;
    console.log("activated " + roomId);
}
$(document).ready(getRoomList());