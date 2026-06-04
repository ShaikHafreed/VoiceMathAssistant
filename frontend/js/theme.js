const themeBtn =
document.getElementById(
    "themeToggle"
);

let dark = false;

themeBtn.addEventListener(
    "click",
    () => {

        dark = !dark;

        document.body.classList.toggle(
            "dark-mode"
        );

        themeBtn.innerText =
            dark
            ? "☀ Light Mode"
            : "🌙 Dark Mode";
    }
);