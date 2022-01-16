$(document).ready(function() {
    $("#saveBtn").click(function() {
        let foodName = $("#foodName").val();
        let quantity = $("#quantity").val();
        let expDate = $("#expDate").val();
        if (foodName.trim() == "") {
            alert("식품 이름을 입력하세요");
            return;
        }
        if (quantity.trim() == "") {
            alert("식품 수량을 입력하세요");
            return;
        }
         if (expDate.trim() == "") {
             alert("식품 유통기한을 입력하세요");
             return;
         }
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        var data = {
            foodName: foodName,
            quantity: quantity,
            expDate: expDate
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/foodsave',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('식품이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // saveBtn

    $("#updateBtn").click(function() {
        let foodName = $("#m_foodName").val();
        let quantity = $("#m_quantity").val();
        let expDate = $("#m_expDate").val();
        if (foodName.trim() == "") {
                    alert("식품 이름을 입력하세요");
                    return;
                }
                if (quantity.trim() == "") {
                    alert("식품 수량을 입력하세요");
                    return;
                }
                 if (expDate.trim() == "") {
                     alert("식품 유통기한을 입력하세요");
                     return;
                 }
                // 버튼 눌렀을때 restapi 로 데이터 전송(json)
                var data = {
                    foodName: foodName,
                    quantity: quantity,
                    expDate: expDate
                };

        // 업데이트를 하기위한 키값
        let id = $("#m_id").val();

        $.ajax({
            type : 'PUT',
            url : '/api/v1/food/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('식품이 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // updateBtn

    $("#delBtn").click(function() {
        // 버튼 눌렀을때 restapi 로 데이터 전송(json)
        // 업데이트를 하기위한 키값
        let id = $("#m_id").val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/food/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function () {
            alert('식품이 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    });  // delBtn
});


function modal_show(id, foodName, quantity, expDate) {
    console.log(id);
    console.log(foodName);
    console.log(quantity);
    console.log(expDate);
    // 클릭한 위치의 테이블의 데이터를 모달에 값을 셋팅
    $("#m_id").val(id);
    $("#m_foodName").val(foodName);
    $("#m_quantity").val(quantity);
    $("#m_expDate").val(expDate);

    $("#myModal").modal();
}

$(document).ready(function(){
 $('#foodDbTable th').each(function (column) {
 $(this).click(function() {
    if($(this).is('.asc')) {
       $(this).removeClass('asc');
       $(this).addClass('desc');
       sortdir=-1;

    } else {
      $(this).addClass('asc');
      $(this).removeClass('desc'); sortdir=1;
    }

    $(this).siblings().removeClass('asc');
    $(this).siblings().removeClass('desc');

    var rec = $('#foodDbTable').find('tbody>tr').get();

    rec.sort(function (a, b) {
      var val1 = $(a).children('td').eq(column).text().toUpperCase();
      var val2 = $(b).children('td').eq(column).text().toUpperCase();
      return (val1 < val2)?-sortdir:(val1>val2)?sortdir:0;
    });

    $.each(rec, function(index, row) {
        $('#foodDbTable tbody').append(row);
    });
   });
  });
 });




