document.addEventListener('DOMContentLoaded', () => {
  (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
    const $notification = $delete.parentNode;

    $delete.addEventListener('click', () => {

      $notification.parentNode.removeChild($notification);
    });
  });
});
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

// Initialize all input of type date
var calendars = bulmaCalendar.attach('[type="date"]', options);

// Loop on each calendar initialized
for(var i = 0; i < calendars.length; i++) {
	// Add listener to select event
	calendars[i].on('select', date => {
		console.log(date);
	});
}

// To access to bulmaCalendar instance of an element
var element = document.querySelector('#my-element');
if (element) {
	// bulmaCalendar instance is available as element.bulmaCalendar
	element.bulmaCalendar.on('select', function(datepicker) {
		console.log(datepicker.data.value());
	});
}


