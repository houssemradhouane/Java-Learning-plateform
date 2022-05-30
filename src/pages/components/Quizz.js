import React, { useState } from 'react';
import './Quizz.css';

import styled from "styled-components"

export default function Quizz() {
	const questions = [
		{
			questionText: 'Quelle est la question 1 ?',
			answerOptions: [
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Vrai', isCorrect: true },
				{ answerText: 'Faux', isCorrect: false },
			],
		},
		{
			questionText: 'Quelle est la question 2 ?',
			answerOptions: [
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Vrai', isCorrect: true },
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Faux', isCorrect: false },
			],
		},
		{
			questionText: 'Quelle est la question 3 ?',
			answerOptions: [
				{ answerText: 'Vrai', isCorrect: true },
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Faux', isCorrect: false },
			],
		},
		{
			questionText: 'Quelle est la question 4 ?',
			answerOptions: [
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Faux', isCorrect: false },
				{ answerText: 'Vrai', isCorrect: true },
			],
		},
	];

	const [currentQuestion, setCurrentQuestion] = useState(0);
	const [showScore, setShowScore] = useState(false);
	const [score, setScore] = useState(0);

	const handleAnswerOptionClick = (isCorrect) => {
		if (isCorrect) {
			setScore(score + 1);
		}

		const nextQuestion = currentQuestion + 1;
		if (nextQuestion < questions.length) {
			setCurrentQuestion(nextQuestion);
		} else {
			setShowScore(true);
		}
	};
	return (
        <QuizzWrap>
            <QuizzBox>
                {showScore ? (
                    <ScoreSection>
                        {score} sur {questions.length}
                    </ScoreSection>
                ) : (
                    <>
                        <QuestionSection>
                            <QuestionCount>
                                <span>Question {currentQuestion + 1}</span>/{questions.length}
                            </QuestionCount>
                            <QuestionText>{questions[currentQuestion].questionText}</QuestionText>
                        </QuestionSection>
                        <AnswerSection>
                            {questions[currentQuestion].answerOptions.map((answerOption) => (
                                <AnswerButton onClick={() => handleAnswerOptionClick(answerOption.isCorrect)}>{answerOption.answerText}</AnswerButton>
                            ))}
                        </AnswerSection>
                    </>
                )}
            </QuizzBox>
        </QuizzWrap>
	);
}
const QuizzWrap = styled.div`
    margin: 0;
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
`

const QuizzBox = styled.div`
    background-color: #4CAF50;
    width: 450px;
    min-height: 200px;
    height: min-content;
    border-radius: 15px;
    padding: 20px;
    box-shadow: 10px 10px 42px 0px rgba(0, 0, 0, 0.75);
    display: flex;
    justify-content: space-evenly;
    font-family: "Verdana", cursive, sans-serif;
    color: #ffffff;
`

const ScoreSection = styled.div`
    display: flex;
    font-size: 24px;
    align-items: center;
`
const QuestionSection = styled.div`
    width: 100%;
    position: relative;
`

const QuestionCount = styled.div`
    margin-bottom: 20px;
    position: relative;
    span{
        font-size: 28px;
    }
`
const QuestionText = styled.div`
    margin-bottom: 12px;
`
const AnswerSection = styled.div`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
`

const AnswerButton = styled.div`
    width: 100%;
    font-size: 16px;
    color: #ffffff;
    background-color: #29892C;
    border-radius: 15px;
    display: flex;
    padding: 5px;
    justify-content: flex-start;
    align-items: center;
    border: 3px solid #4AE14F;
    cursor: pointer;
    &:hover {
        background-color: #4AE14F;
      }
    &:focus {
        outline: none;
    }
    svg {
        margin-right: 5px;
    }
`