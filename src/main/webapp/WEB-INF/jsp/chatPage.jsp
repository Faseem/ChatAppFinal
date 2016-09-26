<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglibs.jsp"%>


<H3>Chat With User : ${userToChatWith.name}</H3>


<div class="row chat-window col-xs-3 col-md-9 " id="chat_window_1"
	style="margin-left: 10px; height: 1000px">
	<div class="col-xs-12 col-md-12">
		<div class="panel-heading top-bar">
			<div class="col-md-8 col-xs-8">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-comment"></span> Chat -
					${userToChatWith.name}
				</h3>
			</div>
			<div class="col-md-4 col-xs-4" style="text-align: right;">
				<a href="#"><span id="minim_chat_window"
					class="glyphicon glyphicon-minus icon_minim"></span></a> <a href="#"><span
					class="glyphicon glyphicon-remove icon_close"
					data-id="chat_window_1"></span></a>
			</div>
		</div>

		<div class="panel-body msg_container_base">
			<c:forEach items="${chats}" var="chat">
				<c:if test="${chat.userSend.name!=userToChatWith.name}">


					<!-- sending messages -->
					<div class="row msg_container base_sent">
						<div class="col-md-10 col-xs-10">
							<div class="messages msg_sent">
								<p>${chat.message}</p>
								<time datetime="2009-11-13T20:00">"${chat.time}"</time>
							</div>
						</div>
						<div class=" col-md-1 col-xs-1  avatar">
							<img
								src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
								class=" img-responsive ">
						</div>
					</div>



				</c:if>


				<c:if test="${chat.userSend.name==userToChatWith.name}">

					<!-- Recieving messages -->

					<div class="row msg_container base_receive">
						<div class=" col-md-1 col-xs-1 avatar">
							<img
								src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
								class=" img-responsive ">
						</div>
						<div class="col-md-10 col-xs-10">
							<div class="messages msg_receive">
								<p>${chat.message}</p>
								<time datetime="2009-11-13T20:00">"${chat.time}"</time>
							</div>
						</div>
					</div>


				</c:if>
			
			</c:forEach>

			</div>
		



		<div class="panel-footer">
			<div class="input-group">
				<input id="btn-input" type="text"
					class="form-control input-sm chat_input"
					placeholder="Write your message here..." /> <span
					class="input-group-btn">
					<button class="btn btn-primary btn-sm" id="btn-chat">Send</button>
				</span>
			</div>
		</div>

	</div>
</div>


<!--  <div class="btn-group dropup">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-cog"></span>
            <span class="sr-only">Toggle Dropdown</span>
        </button>
        <ul class="dropdown-menu" role="menu">
            <li><a href="#" id="new_chat"><span class="glyphicon glyphicon-plus"></span> Novo</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-list"></span> Ver outras</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-remove"></span> Fechar Tudo</a></li>
            <li class="divider"></li>
            <li><a href="#"><span class="glyphicon glyphicon-eye-close"></span> Invisivel</a></li>
        </ul>
    </div> --> --%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglibs.jsp"%>

<style type="text/css">
	@import url(http://fonts.googleapis.com/css?family=Lato:100,300,400,700);
@import url(http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css);

html, body {
    background: #e5e5e5;
    font-family: 'Lato', sans-serif;
    margin: 0px auto;
}
::selection{
  background: rgba(82,179,217,0.3);
  color: inherit;
}
a{
  color: rgba(82,179,217,0.9);
}

/* M E N U */

.menu {
    position: fixed;
    top: 0px;
    left: 0px;
    right: 0px;
    width: 100%;
    height: 50px;
    background: rgba(82,179,217,0.9);
    z-index: 100;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}

.back {
    position: absolute;
    width: 90px;
    height: 50px;
    top: 0px;
    left: 0px;
    color: #fff;
    line-height: 50px;
    font-size: 30px;
    padding-left: 10px;
    cursor: pointer;
}
.back img {
    position: absolute;
    top: 5px;
    left: 30px;
    width: 40px;
    height: 40px;
    background-color: rgba(255,255,255,0.98);
    border-radius: 100%;
    -webkit-border-radius: 100%;
    -moz-border-radius: 100%;
    -ms-border-radius: 100%;
    margin-left: 15px;
    }
.back:active {
    background: rgba(255,255,255,0.2);
}
.name{
    position: absolute;
    top: 3px;
    left: 110px;
    font-family: 'Lato';
    font-size: 25px;
    font-weight: 300;
    color: rgba(255,255,255,0.98);
    cursor: default;
}
.last{
    position: absolute;
    top: 30px;
    left: 115px;
    font-family: 'Lato';
    font-size: 11px;
    font-weight: 400;
    color: rgba(255,255,255,0.6);
    cursor: default;
}

/* M E S S A G E S */

.chat {
    list-style: none;
    background: none;
    margin: 0;
    padding: 0 0 50px 0;
    margin-top: 60px;
    margin-bottom: 10px;
}
.chat li {
    padding: 0.5rem;
    overflow: hidden;
    display: flex;
}
.chat .avatar {
    width: 40px;
    height: 40px;
    position: relative;
    display: block;
    z-index: 2;
    border-radius: 100%;
    -webkit-border-radius: 100%;
    -moz-border-radius: 100%;
    -ms-border-radius: 100%;
    background-color: rgba(255,255,255,0.9);
}
.chat .avatar img {
    width: 40px;
    height: 40px;
    border-radius: 100%;
    -webkit-border-radius: 100%;
    -moz-border-radius: 100%;
    -ms-border-radius: 100%;
    background-color: rgba(255,255,255,0.9);
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
.chat .day {
    position: relative;
    display: block;
    text-align: center;
    color: #c0c0c0;
    height: 20px;
    text-shadow: 7px 0px 0px #e5e5e5, 6px 0px 0px #e5e5e5, 5px 0px 0px #e5e5e5, 4px 0px 0px #e5e5e5, 3px 0px 0px #e5e5e5, 2px 0px 0px #e5e5e5, 1px 0px 0px #e5e5e5, 1px 0px 0px #e5e5e5, 0px 0px 0px #e5e5e5, -1px 0px 0px #e5e5e5, -2px 0px 0px #e5e5e5, -3px 0px 0px #e5e5e5, -4px 0px 0px #e5e5e5, -5px 0px 0px #e5e5e5, -6px 0px 0px #e5e5e5, -7px 0px 0px #e5e5e5;
    box-shadow: inset 20px 0px 0px #e5e5e5, inset -20px 0px 0px #e5e5e5, inset 0px -2px 0px #d7d7d7;
    line-height: 38px;
    margin-top: 5px;
    margin-bottom: 20px;
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}

.other .msg {
    order: 1;
    border-top-left-radius: 0px;
    box-shadow: -1px 2px 0px #D4D4D4;
}
.other:before {
    content: "";
    position: relative;
    top: 0px;
    right: 0px;
    left: 40px;
    width: 0px;
    height: 0px;
    border: 5px solid #fff;
    border-left-color: transparent;
    border-bottom-color: transparent;
}

.self {
    justify-content: flex-end;
    align-items: flex-end;
}
.self .msg {
    order: 1;
    border-bottom-right-radius: 0px;
    box-shadow: 1px 2px 0px #D4D4D4;
}
.self .avatar {
    order: 2;
}
.self .avatar:after {
    content: "";
    position: relative;
    display: inline-block;
    bottom: 19px;
    right: 0px;
    width: 0px;
    height: 0px;
    border: 5px solid #fff;
    border-right-color: transparent;
    border-top-color: transparent;
    box-shadow: 0px 2px 0px #D4D4D4;
}

.msg {
    background: white;
    min-width: 50px;
    padding: 10px;
    border-radius: 2px;
    box-shadow: 0px 2px 0px rgba(0, 0, 0, 0.07);
}
.msg p {
    font-size: 0.8rem;
    margin: 0 0 0.2rem 0;
    color: #777;
}
.msg img {
    position: relative;
    display: block;
    width: 450px;
    border-radius: 5px;
    box-shadow: 0px 0px 3px #eee;
    transition: all .4s cubic-bezier(0.565, -0.260, 0.255, 1.410);
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
@media screen and (max-width: 800px) {
    .msg img {
    width: 300px;
}
}
@media screen and (max-width: 550px) {
    .msg img {
    width: 200px;
}
}

.msg time {
    font-size: 0.7rem;
    color: #ccc;
    margin-top: 3px;
    float: right;
    cursor: default;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
}
.msg time:before{
    content:"\f017";
    color: #ddd;
    font-family: FontAwesome;
    display: inline-block;
    margin-right: 4px;
}

emoji{
    display: inline-block;
    height: 18px;
    width: 18px;
    background-size: cover;
    background-repeat: no-repeat;
    margin-top: -7px;
    margin-right: 2px;
    transform: translate3d(0px, 3px, 0px);
}
emoji.please{background-image: url(http://imgur.com/ftowh0s.png);}
emoji.lmao{background-image: url(http://i.imgur.com/MllSy5N.png);}
emoji.happy{background-image: url(http://imgur.com/5WUpcPZ.png);}
emoji.pizza{background-image: url(http://imgur.com/voEvJld.png);}
emoji.cryalot{background-image: url(http://i.imgur.com/UUrRRo6.png);}
emoji.books{background-image: url(http://i.imgur.com/UjZLf1R.png);}
emoji.moai{background-image: url(http://imgur.com/uSpaYy8.png);}
emoji.suffocated{background-image: url(http://i.imgur.com/jfTyB5F.png);}
emoji.scream{background-image: url(http://i.imgur.com/tOLNJgg.png);}
emoji.hearth_blue{background-image: url(http://i.imgur.com/gR9juts.png);}
emoji.funny{background-image: url(http://i.imgur.com/qKia58V.png);}

@-webikt-keyframes pulse {
  from { opacity: 0; }
  to { opacity: 0.5; }
}

::-webkit-scrollbar {
    min-width: 12px;
    width: 12px;
    max-width: 12px;
    min-height: 12px;
    height: 12px;
    max-height: 12px;
    background: #e5e5e5;
    box-shadow: inset 0px 50px 0px rgba(82,179,217,0.9), inset 0px -52px 0px #fafafa;
}

::-webkit-scrollbar-thumb {
    background: #bbb;
    border: none;
    border-radius: 100px;
    border: solid 3px #e5e5e5;
    box-shadow: inset 0px 0px 3px #999;
}

::-webkit-scrollbar-thumb:hover {
    background: #b0b0b0;
  box-shadow: inset 0px 0px 3px #888;
}

::-webkit-scrollbar-thumb:active {
    background: #aaa;
  box-shadow: inset 0px 0px 3px #7f7f7f;
}

::-webkit-scrollbar-button {
    display: block;
    height: 26px;
}

/* T Y P E */

input.textarea {
    position: fixed;
    bottom: 0px;
    left: 0px;
    right: 0px;
    width: 100%;
    height: 50px;
    z-index: 99;
    background: #fafafa;
    border: none;
    outline: none;
    padding-left: 55px;
    padding-right: 55px;
    color: #666;
    font-weight: 400;
}
.emojis {
    position: fixed;
    display: block;
    bottom: 8px;
    left: 7px;
    width: 34px;
    height: 34px;
    background-image: url(http://i.imgur.com/5WUpcPZ.png);
    background-repeat: no-repeat;
    background-size: cover;
    z-index: 100;
    cursor: pointer;
}
.sendButton {
    position: fixed;
    display: block;
    bottom: 8px;
    right: 7px;
    width: 34px;
    height: 34px;
    background-color:aqua;
    background-repeat: no-repeat;
    background-size: cover;
    z-index: 100;
    cursor: pointer;
}
.emojis:active {
    opacity: 0.9;
}
</style>
 
<div class="menu">
	<div class="back" >
	<a href="/chat.html">
		<i class="fa fa-chevron-left"></i> <img
			src="http://i.imgur.com/DY6gND0.png" draggable="false" />
			</a>
	</div>
	<div class="name">${userToChatWith.name}</div>
	<div class="last">(n) New Messages</div>
</div>



<ol class="chat">

	<c:forEach items="${chats}" var="chat">	
		<c:if test="${chat.userSend.name!=userToChatWith.name}">
			<li class="self">
				<div class="avatar">
					<img src="http://i.imgur.com/HYcn9xO.png" draggable="false" />
				</div>
				<div class="msg">
					<p>"${chat.message}"</p>
					
					<time>"${chat.time}"</time>
				</div>
			</li>
		</c:if>

		<c:if test="${chat.userSend.name==userToChatWith.name}">

			<li class="other">
				<div class="avatar">
					<img src="http://i.imgur.com/DY6gND0.png" draggable="false" />
				</div>
				<div class="msg">
					<p>"${chat.message}"</p>
					
					<time>"${chat.time}"</time>
				</div>
			</li>
		</c:if>
		
		</c:forEach>
</ol>

<input class="textarea" type="text" placeholder="Type here!" onkeypress=""/>
<input class="sendButton" type="button" />
<div class="emojis"></div>

    