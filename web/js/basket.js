var masPrIds = new Array();
var generalPrice = 0;
var masPrice = new Array();

var buttonExist = false;
window.onload = function()
{  
  var table = document.getElementsByTagName("table")[0];
  var elA = table.getElementsByTagName("a");
  for (var i=0;i<elA.length;i++)
  {
      elA[i].onclick = addPr;
  }
  
  
};

function addPr(e)
{
    if (!getCookie("user")) document.location="welcome.jsp"; 
    
    if (!buttonExist && masPrIds.length===0) addButton();
    
    var e = e || event;
    var s =  e.srcElement || e.target;
    var str = s.getAttribute("href").replace("#","");
    
    var mas =  str.split("|");
    masPrIds.push(mas[0]);
    masPrice.push(mas[2]);
    generalPrice+=parseInt(mas[2]);
   // alert(generalPrice);
    //создаем элемент корзины
    var p1 = document.createElement("p");
    var br = document.createElement("br");
    var hr = document.createElement("hr");
    var a = document.createElement("a");
    a.setAttribute("href","#k"+mas[0]);
    a.setAttribute("id","#k"+mas[0]);
    a.onclick = basketDelElement;
    var text1 = document.createTextNode(mas[1]);
    var text2 = document.createTextNode("Цена: " + mas[2] + "  ");
    var text3 = document.createTextNode("Кф: " + mas[3] + "  ");
    var text4 = document.createTextNode("Удалить");
    var text5 = document.createTextNode('     '); //неразрывные пробелы!
    a.appendChild(text4);
    p1.appendChild(text1);
    p1.appendChild(br);
    p1.appendChild(hr);
    p1.appendChild(text2);
    p1.appendChild(text5);
    p1.appendChild(text3);
    p1.appendChild(a);
    
    var basket = document.getElementById("basket");
    basket.insertBefore(p1,basket.lastChild);
}

function basketDelElement(e)
{
    if (masPrIds.length===1) removeButton();
    var e = e || event;
    var s =  e.srcElement || e.target;
    var str = s.getAttribute("href").replace("#k","");
    var index = indexInMas(str);
    masPrIds.splice(index,1);
    var resMas = masPrice.splice(index,1);
    generalPrice-=parseInt(resMas[0]);
    //alert(generalPrice);
    var p1 = s.parentNode;
    var basket = document.getElementById("basket");
    basket.removeChild(p1);
}

function indexInMas(v)
{
    for (var i=0;i<masPrIds.length;i++)
    {
        if (masPrIds[i]===v)
        {
            return i;
        }
    }
}

function addButton()
{
    var basket = document.getElementById("basket");
    var pb = document.createElement("p");
    //pb.setAttribute("align","right");
    
    var pb_a = document.createElement("a");
    pb_a.onclick = eventAjax;
    pb_a.setAttribute("href","#button");
    var t1 = document.createTextNode("Заказать");
    pb_a.appendChild(t1);
    pb.appendChild(pb_a);
    basket.appendChild(pb);
}

function removeButton()
{
    var basket = document.getElementById("basket");
    basket.removeChild(basket.lastChild);
}

function eventAjax()
{
    var myobject ={};
    myobject.orders = masPrIds;
    var res = JSON.stringify(myobject);
   // var req = getXmlHttpRequest();
   //alert(res);
   var strPost = "da=" + res;
    var req = getXmlHttpRequest();
    req.onreadystatechange = function()
		{
		if (req.readyState !== 4) return;
                  //  alert(req.responseText);
                    createResultWindow();
                    clearBasket();
                    
		};
    req.open("POST","/Sport1/Order",true);
    
   // req.setRequestHeader("Content-Type", "text/plain");
    req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    req.setRequestHeader("Content-Length", strPost.length);
    req.send(strPost);
}

function checkCookie(str)
{
    if (!str) return false;
    
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

function createResultWindow()
{
    var wnd = window.open('','','width=400,height=200');
    wnd.document.open();
    wnd.document.write('<html>');
    wnd.document.write('<html>');
    wnd.document.write('<head>');
    wnd.document.write('</head>');
    
    var strText = "Спасибо за заказ. К оплате " + generalPrice + " рублей";
    var strText2 = "Прогнозы будут высланы на email сразу после оплаты!";
    
    wnd.document.write('<body>');
    wnd.document.write('<h1 style="color: blue">' + strText + '</h1>');
    wnd.document.write('<h2 style="color: blue">' + strText2 + '</h2>');
    wnd.document.write('</body>');
    
    wnd.document.write('</html>');
    wnd.document.close();
}

function clearBasket()
{
    var basket = document.getElementById("basket");
    while(basket.hasChildNodes())
    {
        basket.removeChild(basket.lastChild);
    }
    
    generalPrice = 0;
    masPrIds.splice(0,masPrIds.length);
    masPrice.splice(0,masPrice.length);
}