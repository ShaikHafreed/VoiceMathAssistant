function goBack() {

    if (document.referrer &&
        document.referrer.length > 0) {

        history.back();

    } else {

        window.location.href =
            "index.html";
    }
}

function goDashboard() {

    window.location.href =
        "index.html";
}