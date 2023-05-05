function search() {
    var query = document.getElementById("search").value;

    var content = document.getElementById("content").innerHTML;

    var re = new RegExp(query, "gi");
    var matches = content.match(re);

    var count = matches ? matches.length : 0;

    var results = document.getElementById("results");
    if (count > 0) {
        results.innerHTML = "Search results for '" + query + "' (" + count + " matches):<br>" + matches.join("<br>");
        var firstMatch = document.getElementById("content").querySelector("[data-match='true']");
        if (firstMatch) {
            firstMatch.scrollIntoView();
        }
    } else {
        results.innerHTML = "Няма резултат за '" + query + "'.";
    }
}

document.querySelector("form").addEventListener("submit", function(event) {
    event.preventDefault();
    search();
});
