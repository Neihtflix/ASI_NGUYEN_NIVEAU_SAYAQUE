$(document).ready(function() {
    $('.ui.form').on('submit', function(event) {
        event.preventDefault(); 

        let formData = {
            name: $('#form-name').val(),
            description: $('#form-desc').val(),
            family: $('#form-family').val(),
            affinity: $('#form-affinity').val(),
            imgUrl: $('#form-imgUrl').val(),
            smallImgUrl: '', 
            id: $('#form-id').val(),
            energy: $('#form-energy').val(),
            hp: $('#form-hp').val(),
            defence: $('#form-defence').val(),
            attack: $('#form-attack').val(),
            price: 0, 
            userId: 0 
        };
        console.log(formData);
    });
});

document.getElementById('submit-button').addEventListener('click', function(event){
    event.preventDefault();

    const form = document.getElementById('card-form');

    let cardData = {
        name: form.name.value,
        description: form.description.value,
        family: form.family.value,
        affinity: form.affinity.value,
        imgUrl: form.imgUrl.value,
        superPower: form.superPower.value,
        hp: Number(form.hp.value),
        energy: Number(form.energy.value),
        attack: Number(form.attack.value),
        defence: Number(form.defence.value),
        smallImgUrl: "default-small-img-url",
        id: Number(form.id.value),
        price: 0,
        userId: 0,
    };
    console.log(cardData);

    fetch('http://vps.cpe-sn.fr:8083/card', {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(cardData),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});
