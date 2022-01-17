$(document).ready(function() {
    $.getJSON("/api/v1/recipe", function(result) {
        var html = "";
        var link = "https://www.youtube.com/results?search_query=";
        $.each(result, function(i, field){
            // console.log(field.rank);
            // console.log(field.title);
            // console.log(field.artist);
            html += "<tr>";
            html += "<td>" + field.rank + "</td>";
            html += "<td>" + field.img + "</td>";
            html += "<td><a href='#' onclick=\"openPop('" + link + field.title + "')\">"
            html += field.title + "</a><td>";
            html += "<td>" + field.link + "</td>";
            html += "</tr>";
        });
        $("#recipelist").append(html);
      });
});

function openPop(url){
    var popup = window.open(url, '레시피 유튜브 검색', 'width=700px,height=800px,scrollbars=yes');
}