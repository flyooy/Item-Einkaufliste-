document.getElementById("itemForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let name = document.getElementById("name").value;
    let menge = document.getElementById("menge").value;
    let laden = document.getElementById("laden").value;
    let gekauft = document.getElementById("gekauft").checked;

    let item = {
        name: name,
        menge: parseInt(menge),
        laden: laden,
        gekauft: gekauft
    };

    fetch('http://localhost:8080/api/items', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item)
    }).then(response => response.json())
      .then(data => {
          addItemToList(data);
      })
      .catch(error => console.error('Error:', error));
});

function addItemToList(item) {
    let itemList = document.getElementById("itemList");
    let li = document.createElement("li");
    li.textContent = `${item.name} - ${item.menge} - ${item.laden} - ${item.gekauft ? 'Gekauft' : 'Noch nicht gekauft'}`;
    itemList.appendChild(li);
}

// Fetch existing items
fetch('http://localhost:8080/api/items')
    .then(response => response.json())
    .then(data => {
        data.forEach(item => addItemToList(item));
    })
    .catch(error => console.error('Error:', error));