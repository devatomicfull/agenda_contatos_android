package github.devatomicfull.agenda_contatos.ui.activity;

import android.os.Bundle;

import android.view.View;

import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import github.devatomicfull.agenda_contatos.R;
import github.devatomicfull.agenda_contatos.data.model.Contato;
import github.devatomicfull.agenda_contatos.databinding.ActivityListBinding;
import github.devatomicfull.agenda_contatos.ui.adapter.List_Adapter;

public class ListActivity extends AppCompatActivity {

    // Declara o objeto de binding gerado automaticamente a partir do layout XML (activity_main.xml)
    // O nome da classe é formado pelo nome do arquivo XML em PascalCase + "Binding".
    // Exemplo: activity_main.xml → ActivityMainBinding
    private ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializa (infla) o layout XML usando o View Binding.
        // Essa linha substitui o uso manual de setContentView(R.layout.activity_main)
        // e cria uma instância de binding que fornece acesso direto a todas as Views do layout.
        binding = ActivityListBinding.inflate(getLayoutInflater());

        // Obtém a View raiz (root) do layout inflado.
        // É essa View que será passada para o setContentView().
        View view = binding.getRoot();

        // Ativa o modo Edge-to-Edge, permitindo que o layout ocupe toda a tela,
        // inclusive as áreas atrás da barra de status e navegação (Android moderno).
        EdgeToEdge.enable(this);

        // Define a View principal da Activity, usando o layout inflado com View Binding.
        setContentView(view);

        // Aplica os recuos (margens internas) necessários para evitar
        // sobreposição de conteúdo com as barras do sistema (status bar, navigation bar, etc).
        // O listener ajusta automaticamente o padding conforme o dispositivo.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listContatosView = binding.listContatosView;

        // Cria lista de contatos de exemplo
        ArrayList<Contato> contatos = getContatos(); // ou carregar do banco de dados

        // Cria e define o adapter
        List_Adapter adapter = new List_Adapter(contatos, this);
        listContatosView.setAdapter(adapter);

        binding.floatingAdd.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Teste do Botao Flotoante", Toast.LENGTH_SHORT).show();
        });
    }

    private ArrayList<Contato> getContatos() {
        ArrayList<Contato> lista = new ArrayList<>();
        lista.add(new Contato("Ana Silva", "ana@email.com" ));
        lista.add(new Contato("Zeca Souza", "zeca@email.com" ));
        lista.add(new Contato("Maria Oliveira", "maria@email.com" ));
        return lista;
    }

}