var button = document.querySelector('button');
var box = document.getElementById('myBox');

function myBox(){
    if(box.style.background == 'green'){
        box.style.background = 'yellow';
    }else {
        box.style.background = 'green';
    }
}