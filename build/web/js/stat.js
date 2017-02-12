window.onload = function()
{
    createEventForSubmit();
};

function createEventForSubmit()
{
    var sub = document.getElementById("sub");
    sub.onclick = implementEventSubmit;
}

function implementEventSubmit()
{
    var my_k =  document.getElementById("my_k").value;
    var my_n =  document.getElementById("my_n").value;
    var my_p =  document.getElementById("my_p").value;
    var my_com =  document.getElementById("my_com").value;
    var strForPost = "my_k=" + my_k + "&";
    strForPost+="my_n=" + my_n + "&";
    strForPost+="my_p=" + my_p + "&";
    strForPost+="my_com=" + my_com;
    
     var req = getXmlHttpRequest();
    req.onreadystatechange = function()
    {
      if (req.readyState===4)
      {
            setGetedValue(req.responseText);
      }
    };
    req.open("POST","/Sport1/BinomServlet",true);
    req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    req.setRequestHeader("Content-length",strForPost.length);
    req.send(strForPost);
    
    return false;
}

function setGetedValue(str)
{
   var resEl =  document.getElementById("res");
   if (resEl.lastChild) resEl.removeChild(resEl.lastChild);
   var resElText =  document.createTextNode(str + "%");
   resEl.appendChild(resElText);
}


