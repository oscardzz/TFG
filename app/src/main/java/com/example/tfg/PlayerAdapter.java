package com.example.tfg;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends ArrayAdapter<Player> {

    private Context mContext;
    private List<Player> playerList;

    public PlayerAdapter(Context context, ArrayList<Player> list) {
        super(context, 0, list);
        mContext = context;
        playerList = list;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Player player = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_item, parent, false);
        }

        ImageView playerImage = convertView.findViewById(R.id.playerImage);
        TextView playerName = convertView.findViewById(R.id.playerName);
        TextView playerTeam = convertView.findViewById(R.id.playerTeam);
        TextView playerPosition = convertView.findViewById(R.id.playerPosition);
        TextView playerNationality = convertView.findViewById(R.id.playerNationality);

        if (player != null) {
            playerName.setText(player.getNombre());
            playerTeam.setText(player.getEquipo());
            playerPosition.setText(player.getPosicion());
            playerNationality.setText(player.getNacionalidad());

            // Cargar la imagen usando Glide
            Glide.with(mContext)
                    .load(player.getImg())
                    .into(playerImage);
        }

        // Configurar el clic en el elemento de la lista
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext != null) {
                    Player clickedPlayer = getItem(position);
                    Intent intent = new Intent(mContext, PlayerDetailActivity.class);
                    intent.putExtra("player", clickedPlayer);
                    mContext.startActivity(intent);
                } else {
                    Log.e("PlayerAdapter", "Context is null");
                }
            }
        });

        return convertView;
    }
}