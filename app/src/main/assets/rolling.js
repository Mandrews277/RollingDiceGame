function rollem() {
    var total = 0;
    var n = document.getElementById('num').value;
    var p = document.getElementById('output').innerHTML;
    var r = 0;

    if (n < 1 || n > 10) {
        alert("You can roll 1 to 10 dice");
    } else {
        if (p != "") {
            p = p.concat("<hr>");
        } else {
            p = p.concat('<button id="clear" onclick="clearme()" style="float:right;">Clear</button>');
        }
    
        for (let i = 0; i < n; i++) {
            r = Math.ceil(Math.random()*6);
            total += r;
            p = p + '<span><img src="./dice/' + r + '.jpg" alt="face ' + r +'" width="50" height="50"></span>';
        }
    
        p = p + "<br> Total: " + total;
        document.getElementById('output').innerHTML = p;
    }
}

function clearme() {
    document.getElementById('output').innerHTML = "";
}