window.onload = function()
{
    var da = getCookie("user");
    if (!getCookie("name"))
    {
        addUserToChat(da);
    }
    setInterval("getOnlineUsers()",3000);
    addEventForButton();
    showMessages();
};

function showMessages()
{
    var myxml = loadXML("/Sport1/users/xml/com.xml");
    var myxsl = loadXML("/Sport1/users/xml/com.xsl");
    var result = xsltTransform(myxml,myxsl);
    var divEl = document.getElementById("messages");
    divEl.innerHTML = result;
}

function addEventForButton()
{
    var but = document.getElementById("but_ok");
    but.onclick = addNewMessage;
}

function getMyXML()
{
    var req = getXmlHttpRequest();
    req.onreadystatechange = function()
    {
      if (req.readyState===4)
      {
         alert(req.responseText);
      }
    };
    req.open("GET","/Sport1/com.xml",true);
    req.send(null);
}

function addNewMessage()
{
    var textar = document.getElementById("mess_text");
    //alert(textar.value);
    
    var str_post = "name=" + getCookie("name") + " " + getCookie("sername") + "&message=" + textar.value;
    var req = getXmlHttpRequest();
  /*  req.onreadystatechange = function()
    {
      if (req.readyState===4)
      {
          showMessages();
       //  alert(req.responseText);
       // 
         //   getMyXML();
      }
    };*/
    req.open("POST","/Sport1/NewMessageServlet",false);
    req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    req.setRequestHeader("Content-length",str_post.length);
    req.send(str_post);
    showMessages();
}

var myObj = {};
function getOnlineUsers()
{
    var str_post = "user=" + "ya";
    var req = getXmlHttpRequest();
    req.onreadystatechange = function()
    {
      if (req.readyState===4)
      {
         // alert(req.responseText);
          myObj =  JSON.parse(req.responseText);
          var mymass = myObj.users;
          showUsers(mymass);
      }
    };
    req.open("POST","/Sport1/GetUserServlet",true);
    req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    req.setRequestHeader("Content-length",str_post.length);
    req.send(str_post);
    
}

function addUserToChat(str)
{
    var str_post = "user=" + str;
    var req = getXmlHttpRequest();
    req.onreadystatechange = function()
    {
      if (req.readyState===4)
      {
          var resStr = req.responseText;
         // alert(resStr);
          var resObj = JSON.parse(resStr);
          document.cookie = "name=" + resObj.name;
          document.cookie = "sername=" + resObj.sername;
          //alert(document.cookie);
      }
    };
    req.open("POST","/Sport1/AddUserInSession",true);
    req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    req.setRequestHeader("Content-length",str_post.length);
    req.send(str_post);
}

function getCookie(c_name)
{
var i,x,y;
var cookieArray = document.cookie.split(";");
for (i=0;i<cookieArray.length;i++)
{
  x = cookieArray[i].substr(0,cookieArray[i].indexOf("="));
  y = cookieArray[i].substr(cookieArray[i].indexOf("=")+1);
  x = x.replace(/^\s+|\s+$/g,"");
  if(x == c_name)
  {
	  return unescape(y);
	  }
	}
}

function showUsers(users)
{
    
    var divUsers = document.getElementById("da");
    while(divUsers.hasChildNodes())
    {
        divUsers.removeChild(divUsers.lastChild);
    }
    
    
    for (var i=0;i<users.length;i++)
    {
        var p = document.createElement("p");
        var resultStr = users[i].name + "  " + users[i].sername;
        var t = document.createTextNode(resultStr);
        p.appendChild(t);
        divUsers.appendChild(p);
    }
}

function loadXML(url)
{
    var req = getXmlHttpRequest();
    req.open("GET",url,false);
    req.send(null);
    return req.responseXML;
}