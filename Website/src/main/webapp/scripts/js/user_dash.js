function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("user-search");
    filter = input.value.toUpperCase();
    table = document.getElementById("users_table");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        fname = tr[i].getElementsByTagName("td")[1];
        lname = tr[i].getElementsByTagName("td")[2];
        uname = tr[i].getElementsByTagName("td")[3];

        // search by first name
        if (fname||lname||uname) {
            var fvalue = fname.textContent || fname.innerText;
            var lvalue = lname.textContent || lname.innerText;
            var uvalue = uname.textContent || uname.innerText;
            if ((fvalue.toUpperCase().indexOf(filter) > -1)||(lvalue.toUpperCase().indexOf(filter) > -1)||(uvalue.toUpperCase().indexOf(filter) > -1)) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }

    }
}