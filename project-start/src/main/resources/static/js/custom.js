firstTime = sessionStorage.getItem("firstTime");

if (firstTime === null){
    alert('Hello from SE352/452');
    sessionStorage.setItem("firstTime", "false");
}    