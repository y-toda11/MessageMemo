// 印刷ボタン
$('#print').click(function(){
    window.print();
})

// jQuery
$(function(){
    var row = $('#table2 tbody').children().length;
    console.log(row);

    if(row >= 15) {
        $('.wrapper').css('overflow-y', 'overlay');
        $('.wrapper').css('height', '463px');
    }
})

