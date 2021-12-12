function getEmployeeInfo() {
    let eid = document.getElementById("info-eid").value;
    let password = document.getElementById("info-password").value;
    document.getElementById("info-eid").value = "";
    document.getElementById("info-password").value = "";

    let obj = {
        "eid": eid,
        "password": password
    }

    let request = new XMLHttpRequest();
    request.open("POST", "/GoodCompany/EmployeeInfo", false);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(obj));
    let response = request.responseText;
    let infobox = document.getElementById("info");
    infobox.value = response;
}

function changePassword() {
    let eid = document.getElementById("cp-eid").value;
    let cPassword = document.getElementById("cp-current-password").value;
    let nPassword = document.getElementById("cp-new-password").value;
    document.getElementById("cp-eid").value = "";
    document.getElementById("cp-current-password").value = "";
    document.getElementById("cp-new-password").value = "";

    let obj = {
        "eid": eid,
        "cPassword": cPassword,
        "nPassword": nPassword
    }

    let request = new XMLHttpRequest();
    request.open("POST", "/GoodCompany/ChangePassword", false);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(obj));
}