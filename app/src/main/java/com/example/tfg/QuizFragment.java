package com.example.tfg;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class QuizFragment extends Fragment {

    private TextView preguntaTextView, puntuacionTextView;
    private Button opcionAButton, opcionBButton, opcionCButton, opcionDButton;
    private Button iniciarButton, siguienteButton;
    private int puntuacion = 0;
    private int preguntaActual = 0;
    private int quizActual = 0;

    private ArrayList<Quiz> quizzes = new ArrayList<>();
    private Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializarQuizzes();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        preguntaTextView = view.findViewById(R.id.pregunta);
        opcionAButton = view.findViewById(R.id.opcionA);
        opcionBButton = view.findViewById(R.id.opcionb);
        opcionCButton = view.findViewById(R.id.opcionc);
        opcionDButton = view.findViewById(R.id.opciond);
        iniciarButton = view.findViewById(R.id.inicar1);
        siguienteButton = view.findViewById(R.id.siguientequiz);
        puntuacionTextView = view.findViewById(R.id.puntuacion);

        iniciarButton.setOnClickListener(this::iniciarQuiz);
        siguienteButton.setOnClickListener(this::siguienteQuiz);

        return view;
    }

    public void inicializarQuizzes() {
        // Inicializar preguntas y quizzes manualmente
        ArrayList<QuizFragment.Pregunta> preguntasQuizGoles = new ArrayList<>();
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en champions?",
                new QuizFragment.Respuesta("Lewandowski", true, 91),
                new QuizFragment.Respuesta("Benzema", false, 89),
                new QuizFragment.Respuesta("Raúl", false, 71),
                new QuizFragment.Respuesta("Shevchenko", false, 48)
        ));

        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en champions?",
                new QuizFragment.Respuesta("Zlatan", false, 48),
                new QuizFragment.Respuesta("Van Nistelrooy", true, 56),
                new QuizFragment.Respuesta("Müller", false, 47),
                new QuizFragment.Respuesta("Eusébio", false, 46)
        ));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en champions?",
                new QuizFragment.Respuesta("Cristiano", true, 140),
                new QuizFragment.Respuesta("Messi", false, 129),
                new QuizFragment.Respuesta("Henry", false, 50),
                new QuizFragment.Respuesta("Di Stéfano", false, 49)
        ));

        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en champions?",
                new QuizFragment.Respuesta("Neymar", true, 43),
                new QuizFragment.Respuesta("Del Piero", false, 42),
                new QuizFragment.Respuesta("Agüero", false, 41),
                new QuizFragment.Respuesta("Puskás", false, 36)
        ));

        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en champions?",
                new QuizFragment.Respuesta("Inzaghi", true, 46),
                new QuizFragment.Respuesta("Drogba", false, 44),
                new QuizFragment.Respuesta("Salah", false, 36),
                new QuizFragment.Respuesta("Cavani", false, 35)
        ));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en La Liga?",
                new QuizFragment.Respuesta("Di Stéfano", true, 227),
                new QuizFragment.Respuesta("César", false, 223),
                new QuizFragment.Respuesta("Quini", false, 219),
                new QuizFragment.Respuesta("Pahiño", false, 210)));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en La Liga?",
                new QuizFragment.Respuesta("Mundo", true, 195),
                new QuizFragment.Respuesta("Villa", false, 185),
                new QuizFragment.Respuesta("Hugo Sánchez", false, 234),
                new QuizFragment.Respuesta("Raúl", false, 228)));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en La Liga?",
                new QuizFragment.Respuesta("Messi", true, 474),
                new QuizFragment.Respuesta("Cristiano", false, 311),
                new QuizFragment.Respuesta("Zarra", false, 251),
                new QuizFragment.Respuesta("Benzema", false, 238)));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en La Premier?",
                new QuizFragment.Respuesta("Shearer", true, 260),
                new QuizFragment.Respuesta("Rooney", false, 208),
                new QuizFragment.Respuesta("Kane", false, 213),
                new QuizFragment.Respuesta("Andy Cole", false, 187)));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en La Premier?",
                new QuizFragment.Respuesta("Defoe", true, 162),
                new QuizFragment.Respuesta("Owen", false, 150),
                new QuizFragment.Respuesta("Les Ferdinand", false, 149),
                new QuizFragment.Respuesta("Sheringham", false, 146)));
        preguntasQuizGoles.add(new QuizFragment.Pregunta("¿Quién tiene más goles en La Premier?",
                new QuizFragment.Respuesta("Agüero", true, 184),
                new QuizFragment.Respuesta("Lampard", false, 177),
                new QuizFragment.Respuesta("Henry", false, 175),
                new QuizFragment.Respuesta("Fowler", false, 163)));

        quizzes.add(new QuizFragment.Quiz(preguntasQuizGoles));

        ArrayList<QuizFragment.Pregunta> preguntasQuizAsistencias = new ArrayList<>();

        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en champions?",
                new QuizFragment.Respuesta("Pirlo", true, 18),
                new QuizFragment.Respuesta("Henry", false, 18),
                new QuizFragment.Respuesta("Lampard", false, 17),
                new QuizFragment.Respuesta("Piqué", false, 17)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en champions?",
                new QuizFragment.Respuesta("Figo", false, 21),
                new QuizFragment.Respuesta("Modric", false, 20),
                new QuizFragment.Respuesta("Robben", true, 22) ,
                new QuizFragment.Respuesta("Scholes", false, 19)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en champions?",
                new QuizFragment.Respuesta("Ozil", true, 24),
                new QuizFragment.Respuesta("Zlatan", false, 23),
                new QuizFragment.Respuesta("Kroos", false, 23),
                new QuizFragment.Respuesta("Lewandowski", false, 21)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en champions?",
                new QuizFragment.Respuesta("Giggs", true, 30),
                new QuizFragment.Respuesta("Benzema", false, 28),
                new QuizFragment.Respuesta("Iniesta", false, 27),
                new QuizFragment.Respuesta("Xavi", false, 25)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en champions?",
                new QuizFragment.Respuesta("Cristiano", true, 42),
                new QuizFragment.Respuesta("Messi", false, 36),
                new QuizFragment.Respuesta("Di María", false, 35),
                new QuizFragment.Respuesta("Neymar", false, 30)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Liga?",
                new QuizFragment.Respuesta("Luis Suárez", true, 71),
                new QuizFragment.Respuesta("Raúl", false, 69),
                new QuizFragment.Respuesta("Dani Alves", false, 67),
                new QuizFragment.Respuesta("Joaquín", false, 66)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Liga?",
                new QuizFragment.Respuesta("Benzema", true, 85),
                new QuizFragment.Respuesta("Kroos", false, 81),
                new QuizFragment.Respuesta("Iniesta", false, 78),
                new QuizFragment.Respuesta("Griezmann", false, 72)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Liga?",
                new QuizFragment.Respuesta("Cristiano", true, 88),
                new QuizFragment.Respuesta("Xavi", false, 86),
                new QuizFragment.Respuesta("Marcelo", false, 84),
                new QuizFragment.Respuesta("Luis Figo", false, 82)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Liga?",
                new QuizFragment.Respuesta("Messi", true, 192),
                new QuizFragment.Respuesta("Modric", false, 90),
                new QuizFragment.Respuesta("Busquets", false, 75),
                new QuizFragment.Respuesta("Piqué", false, 70)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Premier?",
                new QuizFragment.Respuesta("Scholes", false, 55),
                new QuizFragment.Respuesta("Gerrard", false, 55),
                new QuizFragment.Respuesta("Silva", true, 61),
                new QuizFragment.Respuesta("Cantona", false, 56)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Premier?",
                new QuizFragment.Respuesta("Giggs", true, 162),
                new QuizFragment.Respuesta("Lampard", false, 102),
                new QuizFragment.Respuesta("Rooney", false, 103),
                new QuizFragment.Respuesta("Bergkamp", false, 94)
        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Premier?",
                new QuizFragment.Respuesta("De Bruyne", true, 86),
                new QuizFragment.Respuesta("Fabregas", false, 84),
                new QuizFragment.Respuesta("Milner", false, 80),
                new QuizFragment.Respuesta("Beckham", false, 77)
        ));

        quizzes.add(new QuizFragment.Quiz(preguntasQuizAsistencias));
    }

    public void iniciarQuiz(View view) {
        preguntaActual = 0;
        puntuacion = 0;
        actualizarPregunta();
        puntuacionTextView.setText("Puntuación: " + puntuacion);
        // Reiniciar visibilidad de los botones y otros elementos de UI si es necesario
        opcionAButton.setVisibility(View.VISIBLE);
        opcionBButton.setVisibility(View.VISIBLE);
        opcionCButton.setVisibility(View.VISIBLE);
        opcionDButton.setVisibility(View.VISIBLE);
        siguienteButton.setVisibility(View.GONE);
    }

    public void siguienteQuiz(View view) {
        quizActual++;
        if (quizActual < quizzes.size()) {
            iniciarQuiz(view);
        } else {
            preguntaTextView.setText("No hay más quizzes disponibles.");
            siguienteButton.setVisibility(View.GONE);
        }
    }

    public void actualizarPregunta() {
        if (preguntaActual < quizzes.get(quizActual).preguntas.size()) {
            Pregunta pregunta = quizzes.get(quizActual).preguntas.get(preguntaActual);
            preguntaTextView.setText(pregunta.pregunta);
            opcionAButton.setText(pregunta.opcionA.texto);
            opcionBButton.setText(pregunta.opcionB.texto);
            opcionCButton.setText(pregunta.opcionC.texto);
            opcionDButton.setText(pregunta.opcionD.texto);

            opcionAButton.setOnClickListener(view -> responder(pregunta.opcionA));
            opcionBButton.setOnClickListener(view -> responder(pregunta.opcionB));
            opcionCButton.setOnClickListener(view -> responder(pregunta.opcionC));
            opcionDButton.setOnClickListener(view -> responder(pregunta.opcionD));
        } else {
            mostrarResultadoFinal();
        }
    }

    public void responder(Respuesta respuesta) {
        if (respuesta.correcta) {
            puntuacion += respuesta.puntos;
        }
        puntuacionTextView.setText("Puntuación: " + puntuacion);
        preguntaActual++;
        handler.postDelayed(this::actualizarPregunta, 2000);
    }

    public void mostrarResultadoFinal() {
        preguntaTextView.setText("Quiz terminado! Puntuación: " + puntuacion);
        opcionAButton.setVisibility(View.GONE);
        opcionBButton.setVisibility(View.GONE);
        opcionCButton.setVisibility(View.GONE);
        opcionDButton.setVisibility(View.GONE);
        if (quizActual < quizzes.size() - 1) {
            siguienteButton.setVisibility(View.VISIBLE);
        } else {
            siguienteButton.setVisibility(View.GONE);
        }
    }

    static class Quiz {
        ArrayList<Pregunta> preguntas;

        Quiz(ArrayList<Pregunta> preguntas) {
            this.preguntas = preguntas;
        }
    }

    static class Pregunta {
        String pregunta;
        Respuesta opcionA;
        Respuesta opcionB;
        Respuesta opcionC;
        Respuesta opcionD;

        Pregunta(String pregunta, Respuesta opcionA, Respuesta opcionB, Respuesta opcionC, Respuesta opcionD) {
            this.pregunta = pregunta;
            this.opcionA = opcionA;
            this.opcionB = opcionB;
            this.opcionC = opcionC;
            this.opcionD = opcionD;
        }
    }

    static class Respuesta {
        String texto;
        boolean correcta;
        int puntos;

        Respuesta(String texto, boolean correcta, int puntos) {
            this.texto = texto;
            this.correcta = correcta;
            this.puntos = puntos;
        }
    }
}
