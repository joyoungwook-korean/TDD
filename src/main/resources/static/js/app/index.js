var main ={
    init : function (){
        var _this = this;
        $('#btn-save').onclick(function () {
           _this.save();
        });
    },
    save : function () {
        var data ={
            title: $('#title').value(),
            author : $('#author').value(),
            content: $('#content').val()
    };

        $.ajax({
        type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록 되었습니다');
            window.location.href= '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};