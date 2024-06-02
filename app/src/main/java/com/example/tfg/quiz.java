package com.example.tfg;
import android.os.Handler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class quiz extends AppCompatActivity {

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
        setContentView(R.layout.quiz);

        preguntaTextView = findViewById(R.id.pregunta);
        opcionAButton = findViewById(R.id.opcionA);
        opcionBButton = findViewById(R.id.opcionb);
        opcionCButton = findViewById(R.id.opcionc);
        opcionDButton = findViewById(R.id.opciond);
        iniciarButton = findViewById(R.id.inicar1);
        siguienteButton = findViewById(R.id.siguientequiz);
        puntuacionTextView = findViewById(R.id.puntuacion);

        iniciarButton.setOnClickListener(v -> iniciarQuiz());
        siguienteButton.setOnClickListener(v -> siguienteQuiz());

        inicializarQuizzes();
    }

    private void inicializarQuizzes() {
        // Inicializar preguntas y quizzes manualmente
        ArrayList<Pregunta> preguntasQuiz1 = new ArrayList<>();
        preguntasQuiz1.add(new Pregunta("¿Que Ciudad tiene más títulos?",
                new Respuesta("Paris", true, 0),
                new Respuesta("Londres", false, 0),
                new Respuesta("Roma", false, 0),
                new Respuesta("Madrid", false, 50)));

        preguntasQuiz1.add(new Pregunta("¿Quien lleva más goles marcados?",
                new Respuesta("Berlin", false, 0),
                new Respuesta("Roma", true, 50),
                new Respuesta("Lisboa", false, 0),
                new Respuesta("Paris", false, 0)));

        quizzes.add(new Quiz(preguntasQuiz1));
    }

    private void iniciarQuiz() {
        preguntaActual = 0;
        puntuacion = 0;
        actualizarPregunta();
    }

    private void actualizarPregunta() {
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

    private void verificarRespuesta(Respuesta respuesta, Button boton) {
        if (respuesta.isVerdadero()) {
            puntuacion += 50;
        }
        mostrarResultadoRespuesta(respuesta, boton);
    }

    private void mostrarResultadoRespuesta(Respuesta respuesta, Button boton) {
        String textoOriginal = boton.getText().toString();
        boton.setText(textoOriginal + " (" + respuesta.getResultado() + ")");
        handler.postDelayed(() -> {
                    boton.setText(textoOriginal);
                    preguntaActual++;
                    actualizarPregunta();
                },
                2000);
    }

    private void mostrarResultadoFinal() {
        preguntaTextView.setText("Quiz terminado! Puntuación: " + puntuacion);
        opcionAButton.setVisibility(View.GONE);
        opcionBButton.setVisibility(View.GONE);
        opcionCButton.setVisibility(View.GONE);
        opcionDButton.setVisibility(View.GONE);
    }

    private void siguienteQuiz() {
        quizActual++;
        if (quizActual < quizzes.size()) {
            iniciarQuiz();
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
            this.preguntas = preguntas;
        }

        public ArrayList<Pregunta> getPreguntas() {
            return preguntas;
        }
    }
}