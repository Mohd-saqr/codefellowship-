
function validInput(){
var username = document.getElementById('username').value;
var firstName=document.getElementById('firstName').value;
var LastName=document.getElementById('lastName').value;
    if(username.includes("<")|| firstName.includes("<") || LastName.includes("<")){
        document.getElementById('submit').disabled =true;
        document.getElementById('username').className=('input is-danger')
        document.getElementById('firstName').className=('input is-danger')
        document.getElementById('lastName').className=('input is-danger')
    }
    else{
        document.getElementById('submit').disabled =false;

        document.getElementById('username').className=('input is-success')
         document.getElementById('firstName').className=('input is-success')
          document.getElementById('lastName').className=('input is-success')

    }
}

function check_pass() {
    if (document.getElementById('password').value ==
            document.getElementById('confirm_password').value) {
                document.getElementById('submit').disabled =false;
        document.getElementById('confirm_password').className= ('input is-success');
        document.getElementById('ok_span').className=('icon is-small is-right');
        document.getElementById('ok').className= ('fa-solid fa-check');


    } else {

        document.getElementById('confirm_password').className= ('input is-danger');
        document.getElementById('ok').className= ('fa-solid fa-xmark');
        document.getElementById('submit').disabled =true;

    }
};







