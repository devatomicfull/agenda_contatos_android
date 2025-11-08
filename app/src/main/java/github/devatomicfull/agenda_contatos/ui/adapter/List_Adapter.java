package github.devatomicfull.agenda_contatos.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import github.devatomicfull.agenda_contatos.data.model.Contato;
import github.devatomicfull.agenda_contatos.databinding.ItemListContatBinding;

public class List_Adapter extends BaseAdapter {
    private ItemListContatBinding binding;
    private ArrayList<Contato> contatoArrayList;
    private Context context;

    public List_Adapter(ArrayList<Contato> contatoArrayList, Context context) {
        this.contatoArrayList = contatoArrayList;
        this.context = context;
    }

    /**
     * Retorna a quantidade de itens presentes no conjunto de dados representado por este Adapter.
     *
     * @return Quantidade de itens.
     */
    @Override
    public int getCount() {
        return contatoArrayList.size();
    }

    /**
     * Retorna o item de dados associado à posição especificada no conjunto de dados.
     *
     * @param position Posição do item cujo dado queremos obter dentro do Adapter.
     * @return O Contato de dados na posição especificada.
     */
    @Override
    public Contato getItem(int position) {
        return contatoArrayList.get(position);
    }

    /**
     * Retorna o ID da linha associada à posição especificada na lista.
     *
     * @param position Posição do item dentro do conjunto de dados cujo ID queremos obter.
     * @return O ID do item na posição especificada.
     */
    @Override
    public long getItemId(int position) {
        return contatoArrayList.get(position).getId();
    }

    /**
     * Retorna uma View que exibe os dados na posição especificada do conjunto de dados.
     *
     * Você pode criar a View manualmente ou inflá-la a partir de um arquivo de layout XML.
     * Quando a View é inflada, a View pai (como GridView ou ListView) aplicará parâmetros
     * de layout padrão, a menos que você utilize
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)} para especificar uma View raiz
     * e impedir sua anexação imediata ao layout pai.
     *
     * @param position    Posição do item dentro do conjunto de dados cujo layout queremos exibir.
     * @param convertView A View antiga que pode ser reutilizada, se possível. É importante verificar
     *                    se esta View não é nula e é do tipo apropriado antes de reutilizá-la.
     *                    Caso não seja possível reutilizar, um novo layout deve ser criado.
     *                    Listas heterogêneas podem especificar o número de tipos de View diferentes,
     *                    garantindo que esta View seja sempre do tipo correto (ver
     *                    {@link #getViewTypeCount()} e {@link #getItemViewType(int)}).
     * @param parent      O ViewGroup ao qual esta View será eventualmente anexada.
     * @return Uma View correspondente aos dados na posição especificada.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemListContatBinding binding;

        // Reutiliza a view se possível, senão infla novamente
        if (convertView == null) {
            binding = ItemListContatBinding.inflate(LayoutInflater.from(context), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemListContatBinding) convertView.getTag();
        }

        // Obtém o contato atual
        Contato contato = getItem(position);

        // Preenche os dados nas views via binding
        binding.nomeText.setText(contato.getNome());
        binding.emailText.setText(contato.getEmail());

/*
        if (contato.getImagem() != null) {
            binding.imgContato.setImageBitmap(contato.getImagem());
        } else {
            binding.imgContato.setImageResource(R.drawable.ic_32_camera);
        }
*/

        return convertView;
    }
}
