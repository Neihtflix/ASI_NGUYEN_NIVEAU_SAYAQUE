let urlParams = new URLSearchParams(window.location.search);

document.getElementById('balance').innerHTML =  localStorage.getItem('balance');
if ( urlParams.get('action')== "SELL") {
	document.getElementById('action').innerHTML = `SELL <div class="sub header">Sell your card to get money</div>`;
}
else {
	document.getElementById('action').innerHTML = `BUY <div class="sub header">Buy a card to get stronger</div>`;
}

function to_buy() {
  window.location.href = 'cardList.html?action=BUY';
}

function to_sell() {
  window.location.href = 'cardList.html?action=SELL';
}

function buy(user_id, card_id) {
	let url = '/store/buy';
	let data = { user_id: Number(user_id), card_id: Number(card_id) };
	
	fetch(url, {
	  method: 'POST',
	  body: JSON.stringify(data),
	  headers: {
	    'Content-Type': 'application/json'
	  }
	})
	.then(response => {
	  console.log('Request succeeded with JSON response', response);
	})
	.catch(error => {
	  console.log('Request failed', error);
	});
}

function sell(user_id, card_id) {
	let url = '/store/sell';
	let data = { user_id: Number(user_id), card_id: Number(card_id) };
	
	fetch(url, {
	  method: 'POST',
	  body: JSON.stringify(data),
	  headers: {
	    'Content-Type': 'application/json'
	  }
	})
	.then(response => {
	  console.log('Request succeeded with JSON response', response);
	})
	.catch(error => {
	  console.log('Request failed', error);
	});
}



