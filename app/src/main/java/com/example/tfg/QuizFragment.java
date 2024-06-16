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
        // Inicializar preguntas y quizzes manualmente, tal como lo hiciste en QuizFragment
        // Aquí puedes agregar las mismas preguntas y quizzes que tenías en tu QuizFragment

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
                new QuizFragment.Respuesta("Messi", true, 192),
                new QuizFragment.Respuesta("Xavi", false, 126),
                new QuizFragment.Respuesta("Cristiano", false, 120),
                new QuizFragment.Respuesta("Modric", false, 87)

        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Premier?",
                new QuizFragment.Respuesta("Milner", true, 88),
                new QuizFragment.Respuesta("Beckham", false, 80),
                new QuizFragment.Respuesta("Ozil", false, 76),
                new QuizFragment.Respuesta("Cantona", false, 73)

        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Premier?",
                new QuizFragment.Respuesta("De Bruyne", true, 101),
                new QuizFragment.Respuesta("Bergkamp", false, 94),
                new QuizFragment.Respuesta("Silva", false, 93),
                new QuizFragment.Respuesta("Gerrard", false, 92)

        ));
        preguntasQuizAsistencias.add(new QuizFragment.Pregunta("¿Quién tiene más asistencias en La Premier?",
                new QuizFragment.Respuesta("Giggs", true, 162),
                new QuizFragment.Respuesta("Fabregas", false, 111),
                new QuizFragment.Respuesta("Rooney", false, 103),
                new QuizFragment.Respuesta("Lampard", false, 102)
        ));

        quizzes.add(new QuizFragment.Quiz(preguntasQuizAsistencias));

        ArrayList<QuizFragment.Pregunta> preguntasQuizTitulos = new ArrayList<>();


        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de la Champions?",
                new QuizFragment.Respuesta("Marseille", false, 1),
                new QuizFragment.Respuesta("Borussia Dortmund", false, 1),
                new QuizFragment.Respuesta("Feyenoord", false, 1),        new QuizFragment.Respuesta("Porto", true, 2)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de la Champions?",
                new QuizFragment.Respuesta("Chelsea", true, 2),
                new QuizFragment.Respuesta("Celtic", false, 1),
                new QuizFragment.Respuesta("Hamburg", false, 1),
                new QuizFragment.Respuesta("Steaua Bucharest", false, 1)
        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de la Champions?",
                new QuizFragment.Respuesta("Juventus", false, 2),
                new QuizFragment.Respuesta("Benfica", false, 2),
                new QuizFragment.Respuesta("Nottingham Forest", false, 2),
                new QuizFragment.Respuesta("Inter Milan", true, 3)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de la Champions?",
                new QuizFragment.Respuesta("Barcelona", true, 5),
                new QuizFragment.Respuesta("Ajax", false, 4),
                new QuizFragment.Respuesta("Manchester United", false, 3),
                new QuizFragment.Respuesta("Aston Villa", false, 1)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de la Champions?",
                new QuizFragment.Respuesta("Real Madrid", true, 15),
                new QuizFragment.Respuesta("AC Milan", false, 7),
                new QuizFragment.Respuesta("Liverpool", false, 6),
                new QuizFragment.Respuesta("Bayern Munich", false, 6)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de La  Liga?",
                new QuizFragment.Respuesta("Valencia", true, 6),
                new QuizFragment.Respuesta("Real Sociedad", false, 2),
                new QuizFragment.Respuesta("Deportivo La Coruña", false, 1),
                new QuizFragment.Respuesta("Sevilla", false, 1)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de La  Liga?",
                new QuizFragment.Respuesta("Real Madrid", true, 36),
                new QuizFragment.Respuesta("Barcelona", false, 27),
                new QuizFragment.Respuesta("Atletico Madrid", false, 11),
                new QuizFragment.Respuesta("Athletic Bilbao", false, 8)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de La  Premier?",
                new QuizFragment.Respuesta("Newcastle United", true, 4),
                new QuizFragment.Respuesta("Sheffield Wednesday", false, 4),
                new QuizFragment.Respuesta("Leeds United", false, 3),
                new QuizFragment.Respuesta("Wolverhampton Wanderers", false, 3)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de La  Premier?",
                new QuizFragment.Respuesta("Manchester City", true, 9),
                new QuizFragment.Respuesta("Aston Villa", false, 7),
                new QuizFragment.Respuesta("Chelsea", false, 6),
                new QuizFragment.Respuesta("Sunderland", false, 6)

        ));
        preguntasQuizTitulos.add(new QuizFragment.Pregunta("¿Quién tiene más Copas de La  Premier?",
                new QuizFragment.Respuesta("Manchester United", true, 20),
                new QuizFragment.Respuesta("Liverpool", false, 19),
                new QuizFragment.Respuesta("Arsenal", false, 13),
                new QuizFragment.Respuesta("Everton", false, 9)
        ));

        quizzes.add(new QuizFragment.Quiz(preguntasQuizTitulos));

    }

    public void iniciarQuiz(View view) {
        preguntaActual = 0;
        puntuacion = 0;
        actualizarPregunta();
    }

    public void actualizarPregunta() {
        if (preguntaActual < quizzes.get(quizActual).getPreguntas().size()) {
            Pregunta pregunta = quizzes.get(quizActual).getPreguntas().get(preguntaActual);
            preguntaTextView.setText(pregunta.getTextoPregunta());
            opcionAButton.setText(pregunta.getRespuestas().get(0).getTextoRespuesta());
            opcionBButton.setText(pregunta.getRespuestas().get(1).getTextoRespuesta());
            opcionCButton.setText(pregunta.getRespuestas().get(2).getTextoRespuesta());
            opcionDButton.setText(pregunta.getRespuestas().get(3).getTextoRespuesta());

            opcionAButton.setOnClickListener(v -> verificarRespuesta(pregunta.getRespuestas().get(0), opcionAButton));
            opcionBButton.setOnClickListener(v -> verificarRespuesta(pregunta.getRespuestas().get(1), opcionBButton));
            opcionCButton.setOnClickListener(v -> verificarRespuesta(pregunta.getRespuestas().get(2), opcionCButton));
            opcionDButton.setOnClickListener(v -> verificarRespuesta(pregunta.getRespuestas().get(3), opcionDButton));
        } else {
            mostrarResultadoFinal();
        }
    }

    public void verificarRespuesta(Respuesta respuesta, Button boton) {
        if (respuesta.isVerdadero()) {
            puntuacion += 50;
        }
        mostrarResultadoRespuesta(respuesta, boton);
    }

    public void mostrarResultadoRespuesta(Respuesta respuesta, Button boton) {
        String textoOriginal = boton.getText().toString();
        boton.setText(textoOriginal + " (" + respuesta.getResultado() + ")");
        handler.postDelayed(() -> {
                    boton.setText(textoOriginal);
                    preguntaActual++;
                    actualizarPregunta();
                },
                2000);
    }

    public void mostrarResultadoFinal() {
        preguntaTextView.setText("Quiz terminado! Puntuación: " + puntuacion);
        opcionAButton.setVisibility(View.GONE);
        opcionBButton.setVisibility(View.GONE);
        opcionCButton.setVisibility(View.GONE);
        opcionDButton.setVisibility(View.GONE);
    }

    public void siguienteQuiz(View view) {
        quizActual++;
        if (quizActual < quizzes.size()) {
            iniciarQuiz(view);
        } else {
            preguntaTextView.setText("No hay más quizzes disponibles.");
        }
    }

    private static class Pregunta {
        private String textoPregunta;
        private ArrayList<Respuesta> respuestas;

        public Pregunta(String textoPregunta, Respuesta... respuestas) {
            this.textoPregunta = textoPregunta;
            this.respuestas = new ArrayList<>();
            for (Respuesta respuesta : respuestas) {
                this.respuestas.add(respuesta);
            }
        }

        public String getTextoPregunta() {
            return textoPregunta;
        }

        public ArrayList<Respuesta> getRespuestas() {
            return respuestas;
        }
    }

    private static class Respuesta {
        private String textoRespuesta;
        private boolean verdadero;
        private int resultado;

        public Respuesta(String textoRespuesta, boolean verdadero, int resultado) {
            this.textoRespuesta = textoRespuesta;
            this.verdadero = verdadero;
            this.resultado = resultado;
        }

        public String getTextoRespuesta() {
            return textoRespuesta;
        }

        public boolean isVerdadero() {
            return verdadero;
        }

        public int getResultado() {
            return resultado;
        }
    }

    private static class Quiz {
        private ArrayList<Pregunta> preguntas;

        public Quiz(ArrayList<Pregunta> preguntas) {
            this.preguntas = new ArrayList<>();
            for (Pregunta pregunta : preguntas) {
                this.preguntas.add(pregunta);
            }
        }

        public ArrayList<Pregunta> getPreguntas() {
            return preguntas;
        }
    }
}