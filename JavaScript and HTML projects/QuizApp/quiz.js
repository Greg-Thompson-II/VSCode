// Created while following Web Dev simplidied on Youtube
const startButton = document.getElementById('start-btn')
const nextButton = document.getElementById('next-btn')
const questionContainerElement = document.getElementById('question-container')
let shuffledQuestions, currentQuestionIndex
const questionElement = document.getElementById('question')
const answerButtonsElement = document.getElementById('answer-buttons')

startButton.addEventListener('click', startGame)
nextButton.addEventListener('click', () => {
    currentQuestionIndex++
    setNextQuestion()
})

function startGame(){
    startButton.classList.add('hide')
    shuffledQuestions = questions.sort(() => Math.random() - .5)
    currentQuestionIndex = 0
    questionContainerElement.classList.remove('hide')
    setNextQuestion()
}

function setNextQuestion(){
    resetState()
    showQuestion(shuffledQuestions[currentQuestionIndex])
}

function showQuestion(question) {
    questionElement.innerText = question.question
    question.answers.forEach(answer => {
        const button = document.createElement('button')
        button.innerText = answer.text
        button.classList.add('btn')
        if (answer.correct){
            button.dataset.correct = answer.correct
        }
        button.addEventListener('click', selectAnswer)
        answerButtonsElement.appendChild(button)
    });
}

function resetState() {
    clearStatusClass(document.body)
    nextButton.classList.add('hide')
    while (answerButtonsElement.firstChild) {
        answerButtonsElement.removeChild(answerButtonsElement.firstChild)
    }
}

function selectAnswer(e){
    const selectedButton = e.target
    const correct = selectedButton.dataset.correct
    setStatusClass(document.body, correct)
    Array.from(answerButtonsElement.children).forEach(button => {
        setStatusClass(button, button.dataset.correct)
    })
    if (shuffledQuestions.length > currentQuestionIndex + 1){
        nextButton.classList.remove('hide')
    } else {
        startButton.innerText = "Restart"
        startButton.classList.remove('hide')
    }
}

function setStatusClass(element, correct) {
    clearStatusClass(element)
    if (correct) {
        element.classList.add('correct')
    } else {
        element.classList.add('wrong')
    }
}

function clearStatusClass(element) {
    element.classList.remove('correct')
    element.classList.remove('wrong')
}

const questions = [
    {
        question: 'What does PHP stand for?',
        answers: [
            {text: 'PHP: Hypertext Preprocessor', correct: true},
            {text: 'Personal Hypertext Preprocessor', correct: false},
            {text: 'Private Home Page', correct: false},
            {text: 'Personal Home Page', correct: false}
        ]
    },
    {
        question: 'How do you write "Hello World" in PHP?',
        answers: [
            {text: '"Hello World";', correct: false},
            {text: 'Document.write("Hello World")', correct: false},
            {text: 'echo "Hello World"', correct: true}
        ],
    },
    {
        question: 'All variables in PHP start with what symbol?',
        answers: [
            {text: '$', correct: true},
            {text: '@', correct: false},
            {text: '%', correct: false},
            {text: '&', correct: false}
        ],
    },
    {
        question: 'What is the correct way to add 1 to the $count variable?',
        answers: [
            {text: '$count++', correct: false},
            {text: '$count =+ 1', correct: true},
            {text: '++count', correct: false},
            {text: 'count++', correct: false}
        ],
    },
    {
        question: 'How do you get information from a form that is submitted using the "post" method?',
        answers: [
            {text: 'Request.Form', correct: false},
            {text: '$_GET[];', correct: false},
            {text: '$_POST[];', correct: true},
            {text: 'Request.QueryString;', correct: false}
        ],
    },
    {
        question: 'When using the post method, variables are displayed in the URL:',
        answers: [
            {text: 'True', correct: false},
            {text: 'False', correct: true}
        ],
    },
    {
        question: 'In PHP, you can use both single quotes and double quotes for stings:',
        answers: [
            {text: 'True', correct: true},
            {text: 'False', correct: false}
        ],
    },
    {
        question: 'What is the correct way to create a function in PHP?',
        answers: [
            {text: 'new_function myFunction()', correct: false},
            {text: 'create myFuntion()', correct: false},
            {text: 'function myFunction()', correct: true}
        ],
    },
    {
        question: 'What is the correct way to connect to a MySQL database?',
        answers: [
            {text: 'mysql_connect("localhost");', correct: true},
            {text: 'mysql_query("localhost");', correct: false},
            {text: 'connect_mysql("localhost"); ', correct: false},
            {text: 'mysql_open("localhost");', correct: false}
        ],
    }
]