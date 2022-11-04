const socket = io('http://localhost:8015')
const messageContainer = document.getElementById('message-container')
const messageForm = document.getElementById('send-container')
const messageInput = document.getElementById('message-input')

// send message + input (containers)

const name = prompt('What is your name?')
appendMessage('You joined')
socket.emit('new-user', name)

// when user joins, connection altert
socket.on('chat-message', data => {
  appendMessage(`${data.name}: ${data.message}`)
})

// append -- adds message + name each time a message is sent

socket.on('user-connected', name => {
  appendMessage(`${name} connected`)
})

socket.on('user-disconnected', name => {
  appendMessage(`${name} disconnected`)
})


// user connection and disconnection 
messageForm.addEventListener('submit', e => {
  e.preventDefault()
  const message = messageInput.value
  appendMessage(`You: ${message}`)
  socket.emit('send-chat-message', message)
  messageInput.value = ''
})

// submit button to send

function appendMessage(message) {
  const messageElement = document.createElement('div')
  messageElement.innerText = message
  messageContainer.append(messageElement)
}