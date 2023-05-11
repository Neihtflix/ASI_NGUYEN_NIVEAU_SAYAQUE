function getCardList() {
  return new Promise((resolve, reject) => {
    fetch('/cards', {
      method: 'GET'
    })
      .then(response => response.json())
      .then(data => {
        let cardList = data;
        console.log(data);
        resolve(cardList);
      })
      .catch(error => {
        console.error('Error:', error);
        reject(error);
      });
  });
}



getSellingCardList()
  .then(cardList => {
    let template = document.querySelector("#row");

	for(const card of cardList){
	    let clone = document.importNode(template.content, true);
	
	    newContent= clone.firstElementChild.innerHTML
	                /*.replace(/{{family_src}}/g, card.family_src)*/
	                .replace(/{{family_name}}/g, card.family)
	                .replace(/{{img_src}}/g, card.imgUrl)
	                .replace(/{{name}}/g, card.name)
	                .replace(/{{description}}/g, card.description)
	                .replace(/{{hp}}/g, card.hp)
	                .replace(/{{energy}}/g, card.energy)
	                .replace(/{{attack}}/g, card.attack)
	                .replace(/{{defense}}/g, card.defence)
	                .replace(/{{price}}/g, card.price);
	    clone.firstElementChild.innerHTML= newContent;
	
	    let cardContainer= document.querySelector("#tableContent");
	    cardContainer.appendChild(clone);
	}
    console.log(cardList);
  })
  .catch(error => {
    console.error("wtf help pls");
    console.error(error);
  });







