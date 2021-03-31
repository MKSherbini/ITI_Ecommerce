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