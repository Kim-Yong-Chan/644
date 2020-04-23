<script src="js/jquery-3.4.1.min.js"></script>

   /*마이크와 캠 허용*/
   $(function() {
     navigator.getUserMedia = navigator.getUserMedia ||
     	navigator.webkitGetUserMedia || navigator.mozGetUserMedia;

     /**
      * getUserMedia 성공
      * @param stream
      */
     function success(stream) {
       console.log('success', arguments);

       // 비디오 테그에 stream 바인딩
       document.querySelector('video').srcObject = stream;

       // do something...
     }

     /**
      * getUserMedia 실패
      * @param error
      */
     function error(error) {
       console.log('error', arguments);

       alert('카메라와 마이크를 허용해주세요');
     }

     /**
      * 이벤트 바인딩
      */
     $('useMIC').click(function() {
       navigator.getUserMedia({ audio: true, video: true }, success, error);
     });
   });

    var conn = new WebSocket('ws://localhost:8200/socket');

    function send(message) {
        conn.send(JSON.stringify(message));
    }

    var peerConnection = new RTCPeerConnection(configuration, {
        optional : [ {
            RtpDataChannels : true
        } ]
    });

    var dataChannel = peerConnection.createDataChannel("dataChannel", { reliable: true });

    dataChannel.onerror = function(error) {
        console.log("Error:", error);
    };
    dataChannel.onclose = function() {
        console.log("Data channel is closed");
    };

    peerConnection.createOffer(function(offer) {
        send({
            event : "offer",
            data : offer
        });
        peerConnection.setLocalDescription(offer);
    }, function(error) {
        // Handle error here
    });

    peerConnection.onicecandidate = function(event) {
        if (event.candidate) {
            send({
                event : "candidate",
                data : event.candidate
            });
        }
    };

    peerConnection.setRemoteDescription(new RTCSessionDescription(offer));
    peerConnection.createAnswer(function(answer) {
        peerConnection.setLocalDescription(answer);
            send({
                event : "answer",
                data : answer
            });
    }, function(error) {
        // Handle error here
    });

    handleAnswer(answer){
        peerConnection.setRemoteDescription(new RTCSessionDescription(answer));
    }