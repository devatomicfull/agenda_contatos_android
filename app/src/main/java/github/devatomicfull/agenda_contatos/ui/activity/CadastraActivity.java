package github.devatomicfull.agenda_contatos.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import github.devatomicfull.agenda_contatos.R;


import github.devatomicfull.agenda_contatos.data.dao.ContatoDao;
import github.devatomicfull.agenda_contatos.data.model.Contato;
import github.devatomicfull.agenda_contatos.databinding.ActivityCadastraBinding;

public class CadastraActivity extends AppCompatActivity {

    private ActivityCadastraBinding binding;

    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Inicializa o binding corretamente
        binding = ActivityCadastraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Usa o root diretamente (nunca dá null)
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contato = new Contato();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastra, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mn_cadastra_salva){
            salvaContato();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvaContato() {
        pegaValoresTela();

        ContatoDao dao = new ContatoDao(this);
        dao.insere(contato);
        dao.close();
    }

    private void pegaValoresTela() {
        contato.setNome(binding.nomeText.getText().toString());
        contato.setEmail(binding.emailText.getText().toString());
        contato.setTelefone(binding.telefoneText.getText().toString());
    }
}
