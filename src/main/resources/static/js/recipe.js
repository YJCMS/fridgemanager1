$(document).ready(function() {
    $.getJSON("/api/v1/recipe", function(result) {
        var html = "";
        $.each(result, function(i, field){
            // console.log(field.rank);
            // console.log(field.title);
            // console.log(field.artist);
            html += "<tr>";
            html += "<td>" + field.rank + "</td>";
//            html += "<td>" + field.rank + "</td>";
            html += "<td><img src='" + field.img + "'></td>";
            html +=  "<td onClick=window.open('" + field.link + "')>" + field.title + "</td>";
            //html += "<td>" + field.link + "</td>";
            html += "</tr>";
        });
        $("#recipelist").append(html);
      });
});

