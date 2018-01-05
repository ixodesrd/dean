


function readFile() {

    var files = document.getElementById("input").files;
    if (files && files[0]) {

        var FR = new FileReader();

        FR.addEventListener("load", function(e) {
            // document.getElementById("img").src = e.target.result;
            // document.getElementById("b64").innerHTML = e.target.result;
            var newImage = document.createElement('img');
            newImage.src = e.target.result;
            document.getElementById("img").innerHTML = newImage.outerHTML;
        });

        FR.readAsDataURL(files[0]);
    }

}

