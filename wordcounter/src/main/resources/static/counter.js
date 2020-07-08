function postToCounter(word, text, callback) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/count", true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.onload = function () {
        if (xhr.status === 200) {
            callback(xhr.responseText);
        } else {
            alert('Something went wrong. Returned status of ' + xhr.status);
        }
    }

    let requestContent = JSON.stringify({word, text});
    xhr.send(requestContent);
}

function displayResults(responseText) {
    document.getElementById('output').hidden = false;
    document.getElementById('count').innerText = JSON.parse(responseText)['count'];
}

function processInput() {
    let word = document.getElementById('word').value;
    let text = document.getElementById('text').value;

    if (word === '' || text === '') {
        document.getElementById('output').hidden = true;
        return;
    }

    postToCounter(word, text, displayResults)
}

let wordInput= document.getElementById('word')

wordInput.addEventListener('keydown', e => {
    if(e.key === ' ') e.preventDefault();
});

wordInput.addEventListener('paste', e => e.preventDefault());


document.getElementById('input').addEventListener('keyup', processInput);

