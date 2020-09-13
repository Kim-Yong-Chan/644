function showChat(chat) {
            var savedate = new Date(chat.chatCreatedDate);
            var day = savedate.getUTCDate();
            var month = savedate.getMonth() + 1;
            var year = savedate.getFullYear();
            var hour = savedate.getHours();
            var min = savedate.getMinutes();

            var time = year + "/" + month + "/" + day + "  " + hour + ":" + min;

            if ("[[ ${userId} ]]" === chat.userId) {
                var newChat = document.createElement("li");
                var oldChat = document.getElementById('_chat');
                newChat.setAttribute("class", "right clearfix");
                newChat.innerHTML = [
                    "<span class='chat-img pull-right'>",
                    "<img src='http://placehold.it/50/FA6F57/fff&text=ME' alt='User Avatar' class='img-circle' />",
                    "</span>",
                    "<div class='chat-body clearfix'>",
                    "<div class='header'>",
                    "<small class='text-muted'><span class='glyphicon glyphicon-time'></span>",
                    time,
                    "<strong class='pull-right primary-font'>",
                    chat.userId,
                    "</strong><div>",
                    "<p>",
                    chat.chatStr,
                    "</p></div>"
                ].join(" ");
                oldChat.append(newChat);
            }
            else {
                var newChat = document.createElement("li");
                var oldChat = document.getElementById('_chat');
                newChat.setAttribute("class", "left clearfix");
                newChat.innerHTML = [
                    "<span class='chat-img pull-left'>",
                    "<img src='http://placehold.it/50/819FF7/fff&text=", chat.userId[0], chat.userId[1], "'alt='User Avatar' class='img-circle' />",
                    "</span>",
                    "<div class='chat-body clearfix'>",
                    "<div class='header'>",
                    "<small class='text-muted'><span class='glyphicon glyphicon-time'></span>",
                    time,
                    "<strong class='pull-right primary-font'>",
                    chat.userId,
                    "</strong><div>",
                    "<p>",
                    chat.chatStr,
                    "</p></div>"
                ].join(" ");
                oldChat.append(newChat);
            }
        }
