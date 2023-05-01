let openShopping = document.querySelector('.shopping');
let closeShopping = document.querySelector('.closeShopping');
let list = document.querySelector('.list');
let listCard = document.querySelector('.listCard');
let body = document.querySelector('body');
let total = document.querySelector('.total');
let quantity = document.querySelector('.quantity');

const scrollContent = document.querySelector('.scroll-content');

openShopping.addEventListener('click', ()=>{
    body.classList.add('active');
})
closeShopping.addEventListener('click', ()=>{
    body.classList.remove('active');
})

let products = [
    {
        id: 1,
        name: 'Футболна топка',
        image: 'footballball.jpg',
        description: 'Kачествена футболна топка за игра.',
        price: 19.99
    },
    {
        id: 2,
        name: 'Спортен сак',
        image: 'footballsack.jpg',
        description: 'Спортен сак за пренасяне на екипировка.',
        price: 39.99
    },
    {
        id: 3,
        name: 'Баскетболна топка',
        image: 'basketballball.jpg',
        description: 'Kачествена баскетболна топка за игра.',
        price: 12.99
    },
    {
        id: 4,
        name: 'Баскетболен кош',
        image: 'koshzabasketball.jpg',
        description: 'Практичен кош за баскетбол на закрито.',
        price: 22.99
    },
    {
        id: 5,
        name: 'Волейболна топка',
        image: 'voleybolnatopka.jpg',
        description: 'Kачествена волейболна топка за игра.',
        price: 15.99
    },
    {
        id: 6,
        name: 'Волейболна мрежа',
        image: 'mrejazavoleybol.jpg',
        description: 'Волейболна мрежа за игра на открито или закрито.',
        price: 59.99
    }
];
let listCards  = [];
function initApp(){
    products.forEach((value, key) =>{
        let newDiv = document.createElement('div');
        newDiv.classList.add('item');
        newDiv.innerHTML = `
            <img src="../img/Equipment/${value.image}">
            <div class="title">${value.name}</div>
            <div class="price">${value.price.toLocaleString()}</div>
            <div class="description">${value.description}</div>
            <button onclick="addToCard(${key})">Добави в количката</button>`;
        list.appendChild(newDiv);
    })
}
initApp();
function addToCard(key){
    if(listCards[key] == null){
        listCards[key] = JSON.parse(JSON.stringify(products[key]));
        listCards[key].quantity = 1;
    }
    reloadCard();
}
function reloadCard(){
    listCard.innerHTML = '';
    let count = 0;
    let totalPrice = 0;
    listCards.forEach((value, key)=>{
        totalPrice = totalPrice + value.price;
        count = count + value.quantity;
        if(value != null){
            let newDiv = document.createElement('li');
            newDiv.innerHTML = `
                <div><img src="../img/Equipment/${value.image}"/></div>
                <div>${value.name}</div>
                <div>${value.price.toLocaleString()}</div>
                <br>
                <div>
                    <button onclick="changeQuantity(${key}, ${value.quantity - 1})">-</button>
                    <div class="count">${value.quantity}</div>
                    <button onclick="changeQuantity(${key}, ${value.quantity + 1})">+</button>
                    <br>
                </div>`;
            listCard.appendChild(newDiv);
        }
    })
    total.innerText = totalPrice.toLocaleString();
    quantity.innerText = count;
}
function changeQuantity(key, quantity){
    if(quantity == 0){
        delete listCards[key];
    }else{
        listCards[key].quantity = quantity;
        listCards[key].price = quantity * products[key].price;
    }
    reloadCard();
}

function fadeInOnScroll() {
    const scrollPosition = window.scrollY + window.innerHeight;
    const elementPosition = scrollContent.offsetTop + scrollContent.offsetHeight;

    if (scrollPosition > elementPosition) {
        scrollContent.classList.add('active');
    }
}

window.addEventListener('scroll', fadeInOnScroll);