function createUser(surname, lastname) {
  let url = '/user';
  let data = {

    login: 'myusername',
    pwd: 'mypassword',
    account: 100,
    lastName: surname,
    surName: lastname,
    email: 'john.doe@example.com',
    cardList: [1, 2, 3]
  };

  fetch(url, {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => response.json())
  .then(data => {
    console.log(data);
    localStorage.setItem('user_id', data);
  })
  .then(response => callback())
  .catch(error => {
    console.log('Request failed', error);
  });
}
	
function callback(){
	document.getElementById('user_id').innerHTML = get_user_id();
}


function connexion() {
	let urlParams = new URLSearchParams(window.location.search);
    let firstName = urlParams.get('first-name');
    let lastName = urlParams.get('last-name');
    createUser(firstName, lastName);
    localStorage.setItem('firstname', firstName);
    localStorage.setItem('lastname', lastName);
    localStorage.setItem('balance', 10000);
}

function get_firstname() {
  let firstName = localStorage.getItem('firstname');
  return firstName;
}

function get_user_id() {
  let userId = localStorage.getItem('user_id');
  return userId;
}


