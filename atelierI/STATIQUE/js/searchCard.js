// let card = {
//             family_src:"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",
//             family_name:"DC comics",
//             img_src:"http://www.superherobroadband.com/app/themes/superhero/assets/img/superhero.gif",
//             name:"SUPERMAN",
//             description: "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",
//             hp: "50 HP",
//             energy:"100 Energy",
//             attack:"17 Attack",
//             defense: "80 defence"  
//         };
// let template = document.querySelector("#selectedCard");
// let clone = document.importNode(template.content, true);

// newContent= clone.firstElementChild.innerHTML
//             .replace(/{{family_src}}/g, card.family_src)
//             .replace(/{{family_name}}/g, card.family_name)
//             .replace(/{{img_src}}/g, card.img_src)
//             .replace(/{{name}}/g, card.name)
//             .replace(/{{description}}/g, card.description)
//             .replace(/{{hp}}/g, card.hp)
//             .replace(/{{energy}}/g, card.energy)
//             .replace(/{{attack}}/g, card.attack)
//             .replace(/{{defense}}/g, card.defense);
// clone.firstElementChild.innerHTML= newContent;

// let cardContainer= document.querySelector("#cardContainer");
// cardContainer.appendChild(clone);


document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("#mySearch");
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        let name = e.target.search.value;
        fetchData(name);
    });
});

function fetchData(name) {
    const url = `http://vps.cpe-sn.fr:8083/cards`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            const card = data.find(card => card.name.toLowerCase() === name.toLowerCase());
            if (card) {
                displayCard(card);
            } else {
                console.log(`Card with name ${name} not found.`);
            }
        })
        .catch(error => console.error('Error fetching card data:', error));
}


function displayCard(card) {
    let template = document.querySelector("#selectedCard");
    let clone = document.importNode(template.content, true);

    newContent = clone.firstElementChild.innerHTML
        .replace(/{{family_src}}/g, card.imgUrl) // replace imgUrl with the appropriate property from your actual data
        .replace(/{{family_name}}/g, card.family)
        .replace(/{{img_src}}/g, card.imgUrl)
        .replace(/{{name}}/g, card.name)
        .replace(/{{description}}/g, card.description)
        .replace(/{{hp}}/g, card.hp)
        .replace(/{{energy}}/g, card.energy)
        .replace(/{{attack}}/g, card.attack)
        .replace(/{{defense}}/g, card.defense);
    clone.firstElementChild.innerHTML= newContent;

    let cardContainer = document.querySelector("#cardContainer");
    cardContainer.innerHTML = ''; // clear the container before adding new card
    cardContainer.appendChild(clone);
}



