package com.example.tfg;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private TextView preguntaTextView, puntuacionTextView;
    private Button opcionAButton, opcionBButton, opcionCButton, opcionDButton;
    private Button iniciarButton, siguienteButton;
    private int puntuacion = 0;
    private int preguntaActual = 0;
    private int quizActual = 0;

    private ArrayList<Quiz> quizzes = new ArrayList<>();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz); // Asegúrate de que este sea el nombre correcto de tu archivo XML

        preguntaTextView = findViewById(R.id.pregunta);
        opcionAButton = findViewById(R.id.opcionA);
        opcionBButton = findViewById(R.id.opcionb);
        opcionCButton = findViewById(R.id.opcionc);
        opcionDButton = findViewById(R.id.opciond);
        iniciarButton = findViewById(R.id.inicar1);
        siguienteButton = findViewById(R.id.siguientequiz);
        puntuacionTextView = findViewById(R.id.puntuacion);

        inicializarQuizzes();
    }

    public void inicializarQuizzes() {
        // Inicializar preguntas y quizzes manualmente
        ArrayList<Pregunta> preguntasQuizGoles = new ArrayList<>();
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en champions?",
                new Respuesta("Lewandowski", true, 91),
                new Respuesta("Benzema", false, 89),
                new Respuesta("Raúl", false, 71),
                new Respuesta("Shevchenko", false, 48)
        ));

        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en champions?",
                new Respuesta("Zlatan", false, 48),
                new Respuesta("Van Nistelrooy", true, 56),
                new Respuesta("Müller", false, 47),
                new Respuesta("Eusébio", false, 46)
        ));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en champions?",
                new Respuesta("Cristiano", true, 140),
                new Respuesta("Messi", false, 129),
                new Respuesta("Henry", false, 50),
                new Respuesta("Di Stéfano", false, 49)
        ));

        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en champions?",
                new Respuesta("Neymar", true, 43),
                new Respuesta("Del Piero", false, 42),
                new Respuesta("Agüero", false, 41),
                new Respuesta("Puskás", false, 36)
        ));

        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en champions?",
                new Respuesta("Inzaghi", true, 46),
                new Respuesta("Drogba", false, 44),
                new Respuesta("Salah", false, 36),
                new Respuesta("Cavani", false, 35)
        ));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en La Liga?",
                new Respuesta("Di Stéfano", true, 227),
                new Respuesta("César", false, 223),
                new Respuesta("Quini", false, 219),
                new Respuesta("Pahiño", false, 210)));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en La Liga?",
                new Respuesta("Mundo", true, 195),
                new Respuesta("Villa", false, 185),
                new Respuesta("Hugo Sánchez", false, 234),
                new Respuesta("Raúl", false, 228)));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en La Liga?",
                new Respuesta("Messi", true, 474),
                new Respuesta("Cristiano", false, 311),
                new Respuesta("Zarra", false, 251),
                new Respuesta("Benzema", false, 238)));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en La Premier?",
                new Respuesta("Shearer", true, 260),
                new Respuesta("Rooney", false, 208),
                new Respuesta("Kane", false, 213),
                new Respuesta("Andy Cole", false, 187)));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en La Premier?",
                new Respuesta("Defoe", true, 162),
                new Respuesta("Owen", false, 150),
                new Respuesta("Les Ferdinand", false, 149),
                new Respuesta("Sheringham", false, 146)));
        preguntasQuizGoles.add(new Pregunta("¿Quién tiene más goles en La Premier?",
                new Respuesta("Agüero", true, 184),
                new Respuesta("Lampard", false, 177),
                new Respuesta("Henry", false, 175),
                new Respuesta("Fowler", false, 163)));


        quizzes.add(new Quiz(preguntasQuizGoles));

        ArrayList<Pregunta> preguntasQuizAsistencias = new ArrayList<>();


        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en champions?",
                new Respuesta("Pirlo", true, 18),
                new Respuesta("Henry", false, 18),
                new Respuesta("Lampard", false, 17),
                new Respuesta("Piqué", false, 17)
        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en champions?",
                new Respuesta("Figo", false, 21),
                new Respuesta("Modric", false, 20),
                new Respuesta("Robben", true, 22) ,
                new Respuesta("Scholes", false, 19)
        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en champions?",
                new Respuesta("Ozil", true, 24),
                new Respuesta("Zlatan", false, 23),
                new Respuesta("Kroos", false, 23),
                new Respuesta("Lewandowski", false, 21)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en champions?",
                new Respuesta("Giggs", true, 30),
                new Respuesta("Benzema", false, 28),
                new Respuesta("Iniesta", false, 27),
                new Respuesta("Xavi", false, 25)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en champions?",
                new Respuesta("Cristiano", true, 42),
                new Respuesta("Messi", false, 36),
                new Respuesta("Di María", false, 35),
                new Respuesta("Neymar", false, 30)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en La Liga?",
                new Respuesta("Luis Suárez", true, 71),
                new Respuesta("Raúl", false, 69),
                new Respuesta("Dani Alves", false, 67),
                new Respuesta("Joaquín", false, 66)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en La Liga?",
                new Respuesta("Benzema", true, 85),
                new Respuesta("Kroos", false, 81),
                new Respuesta("Iniesta", false, 78),
                new Respuesta("Griezmann", false, 72)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en La Liga?",
                new Respuesta("Messi", true, 192),
                new Respuesta("Xavi", false, 126),
                new Respuesta("Cristiano", false, 120),
                new Respuesta("Modric", false, 87)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en La Premier?",
                new Respuesta("Milner", true, 88),
                new Respuesta("Beckham", false, 80),
                new Respuesta("Ozil", false, 76),
                new Respuesta("Cantona", false, 73)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en La Premier?",
                new Respuesta("De Bruyne", true, 101),
                new Respuesta("Bergkamp", false, 94),
                new Respuesta("Silva", false, 93),
                new Respuesta("Gerrard", false, 92)

        ));
        preguntasQuizAsistencias.add(new Pregunta("¿Quién tiene más asistencias en La Premier?",
                new Respuesta("Giggs", true, 162),
                new Respuesta("Fabregas", false, 111),
                new Respuesta("Rooney", false, 103),
                new Respuesta("Lampard", false, 102)
        ));

        quizzes.add(new Quiz(preguntasQuizAsistencias));

        ArrayList<Pregunta> preguntasQuizTitulos = new ArrayList<>();


        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de la Champions?",
                new Respuesta("Marseille", false, 1),
                new Respuesta("Borussia Dortmund", false, 1),
                new Respuesta("Feyenoord", false, 1),        new Respuesta("Porto", true, 2)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de la Champions?",
                new Respuesta("Chelsea", true, 2),
                new Respuesta("Celtic", false, 1),
                new Respuesta("Hamburg", false, 1),
                new Respuesta("Steaua Bucharest", false, 1)
        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de la Champions?",
                new Respuesta("Juventus", false, 2),
                new Respuesta("Benfica", false, 2),
                new Respuesta("Nottingham Forest", false, 2),
                new Respuesta("Inter Milan", true, 3)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de la Champions?",
                new Respuesta("Barcelona", true, 5),
                new Respuesta("Ajax", false, 4),
                new Respuesta("Manchester United", false, 3),
                new Respuesta("Aston Villa", false, 1)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de la Champions?",
                new Respuesta("Real Madrid", true, 15),
                new Respuesta("AC Milan", false, 7),
                new Respuesta("Liverpool", false, 6),
                new Respuesta("Bayern Munich", false, 6)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de La  Liga?",
                new Respuesta("Valencia", true, 6),
                new Respuesta("Real Sociedad", false, 2),
                new Respuesta("Deportivo La Coruña", false, 1),
                new Respuesta("Sevilla", false, 1)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de La  Liga?",
                new Respuesta("Real Madrid", true, 36),
                new Respuesta("Barcelona", false, 27),
                new Respuesta("Atletico Madrid", false, 11),
                new Respuesta("Athletic Bilbao", false, 8)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de La  Premier?",
                new Respuesta("Newcastle United", true, 4),
                new Respuesta("Sheffield Wednesday", false, 4),
                new Respuesta("Leeds United", false, 3),
                new Respuesta("Wolverhampton Wanderers", false, 3)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de La  Premier?",
                new Respuesta("Manchester City", true, 9),
                new Respuesta("Aston Villa", false, 7),
                new Respuesta("Chelsea", false, 6),
                new Respuesta("Sunderland", false, 6)

        ));
        preguntasQuizTitulos.add(new Pregunta("¿Quién tiene más Copas de La  Premier?",
                new Respuesta("Manchester United", true, 20),
                new Respuesta("Liverpool", false, 19),
                new Respuesta("Arsenal", false, 13),
                new Respuesta("Everton", false, 9)
        ));

        quizzes.add(new Quiz(preguntasQuizTitulos));

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

    public void siguienteQuiz() {
        quizActual++;
        preguntaActual = 0;
        if (quizActual < quizzes.size()) {
            siguienteButton.setVisibility(View.INVISIBLE);
        } else {
            // No more quizzes available, show final score or reset
            preguntaTextView.setText("¡Has completado todos los quizzes!");
            opcionAButton.setVisibility(View.INVISIBLE);
            opcionBButton.setVisibility(View.INVISIBLE);
            opcionCButton.setVisibility(View.INVISIBLE);
            opcionDButton.setVisibility(View.INVISIBLE);
            siguienteButton.setVisibility(View.INVISIBLE);
            iniciarButton.setVisibility(View.VISIBLE);
        }
    }
    public void opcionAClick(View view) {
        verificarRespuesta(quizzes.get(quizActual).getPreguntas().get(preguntaActual).getRespuestas().get(0), opcionAButton);
    }

    public void opcionBClick(View view) {
        verificarRespuesta(quizzes.get(quizActual).getPreguntas().get(preguntaActual).getRespuestas().get(1), opcionBButton);
    }

    public void opcionCClick(View view) {
        verificarRespuesta(quizzes.get(quizActual).getPreguntas().get(preguntaActual).getRespuestas().get(2), opcionCButton);
    }

    public void opcionDClick(View view) {
        verificarRespuesta(quizzes.get(quizActual).getPreguntas().get(preguntaActual).getRespuestas().get(3), opcionDButton);
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
