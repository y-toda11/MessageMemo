// システム日付
function setDate() {
    let today = new Date();
    let nowYear = today.getFullYear();
    let nowMonth = today.getMonth() + 1;
    let nowDay = today.getDate();

    document.getElementById("today_year").value = nowYear;
    document.getElementById("today_month").value = nowMonth;
    document.getElementById("today_day").value = nowDay;
}

// システム時間
function setTime() {
    let today = new Date();
    let hours = today.getHours();
    let minutes = today.getMinutes(); 

    document.getElementById("hour").value = hours;
    document.getElementById("minute").value = minutes;

    // 13時以降の場合
    if (hours > 12) {
        document.getElementById("hour").value = hours - 12;
    } else if (hours == 0) {
        document.getElementById("hour").value = 12;
    } else {
        document.getElementById("hour").value = hours;
    }

    // AM・PMのチェック
    if (hours >= 0 && hours <= 11) {
        document.getElementById("am").checked = true;
    } else if(hours >= 12 && hours <= 23) {
        document.getElementById("pm").checked = true;
    }
}

// 印刷ボタン
document.getElementById("print").onclick = function() {
    window.print();
}

// チェックボックスの制限
document.getElementById("check1").onclick = function() {
    let check2 = document.getElementById("check2")
    let check3 = document.getElementById("check3")
    if (document.getElementById("check1").checked) {
        check2.disabled = true;
        check3.disabled = true;
    } else {
        check2.disabled = false;
        check3.disabled = false;
    }
}

document.getElementById("check2").onclick = function() {
    let check1 = document.getElementById("check1")
    if (document.getElementById("check2").checked) {
        check1.disabled = true;
        check3.disabled = true;
    } else {
        check1.disabled = false;
        check3.disabled = false;
    }
}

document.getElementById("check3").onclick = function() {
    if (document.getElementById("check3").checked) {
        check1.disabled = true;
        check2.disabled = true;
    } else {
        check1.disabled = false;
        check2.disabled = false;
    }
    // テキストエリアの制限
    let txta = document.getElementById("txta");
        if (document.getElementById("check3").checked) {
            txta.readOnly = false;
        } else {
            txta.readOnly = true;
        }

    document.getElementById("enter").onclick = function() {
        document.getElementById("msg").hidden = false;
    }
}