var out = document.getElementById("listeCoups");
// allow 1px inaccuracy by adding 1
var isScrolledToBottom = out.scrollHeight - out.clientHeight <= out.scrollTop + 1;
if(isScrolledToBottom)
    out.scrollTop = out.scrollHeight;