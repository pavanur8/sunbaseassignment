function uploadFile() {
    const fileInput = document.getElementById('fileInput');
    const file = fileInput.files[0];
    const formData = new FormData();
    formData.append('file', file);

    fetch('/api/upload', {
        method: 'POST',
        body: formData
    }).then(response => response.text())
      .then(data => alert(data));
}

function sendMessage() {
    const userInput = document.getElementById('userInput').value;

    fetch('/api/chat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ prompt: userInput })
    }).then(response => response.text())
      .then(data => {
        document.getElementById('response').innerText = data;
    });
}
