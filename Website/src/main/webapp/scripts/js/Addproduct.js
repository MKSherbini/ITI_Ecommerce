function addCategory(e){
    e.preventDefault();
    console.log("hhhh");
    var categoryName = document.getElementById("categoryName");
    var categories = document.getElementById("categoriesList");
    var req = new XMLHttpRequest();
    req.onreadystatechange = function () {
        if (req.readyState === 4)
            if (req.status === 200) {
                categories.innerHTML += "<option value='"+categoryName.value+"' name='category'>"+categoryName.value+"</option>";
                categoryName.innerText = "";
                categoryName.innerHTML = "";
                categoryName.value = "";
            }
    }
    req.open("POST","addcategory");
    req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    req.send("categoryName="+categoryName.value);
}
// function changeImage(){
//     var file = document.getElementById("image");
//     var image = document.getElementById("productImage");
//     image.src = file.innerText;
// }
var imagesCount = 1;
function changeImage(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#images')
                .append("<img src='"+e.target.result+"' height='150' width='150' style='margin: 10px'/>");
            input.hidden = true;
            $('#inputs')
                .append("<input type='file' name='image"+imagesCount+"' onchange='changeImage(this)'/> ");
            imagesCount++;
        };
        reader.readAsDataURL(input.files[0]);
    }
}