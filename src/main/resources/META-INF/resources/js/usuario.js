function criarObjetoUsuarioDTO(){
    return {
        id: null,
        nome: ""
    };
}

function popularUsuarioDTO(usuarioDTO){
    //Copiar valor do input para formulario
    usuarioDTO.nome = document.getElementById('nome').value;
    return usuario;
}

function limparFormulario(){
    // Limpa o formulário
    document.getElementById('userForm').reset();
}

// Função para cadastrar usuário
function salvarUsuario() {
    let usuarioDTO = criarObjetoUsuarioDTO(); //Instanciar DTO
    usuarioDTO = popularUsuarioDTO(usuarioDTO); //Popular DTO

    // executar requisição para salvar entidade enviando o DTO.
    fetch('/usuario/salvar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuarioDTO) //Convertendo objeto JSON (DTO) em String
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Error ao criar objeto usuário');
        })
        .then(usuarioJSON => {
            console.log('Usuário criado:', usuarioJSON);
            atualizarLista(); // Atualiza a lista de usuários
            limparFormulario();
        })
        .catch(error => console.error('Error:', error));
}

// Função para buscar usuários
function atualizarLista() {
    fetch('/usuario/listar')
        .then(response => response.json())
        .then(usuarios => {
            const userList = document.getElementById('userList');
            userList.innerHTML = '';
            usuarios.forEach(usuarioDTO => {
                const li = document.createElement('li');
                li.textContent = 'Id: '+usuarioDTO.id+', Nome: '+usuarioDTO.nome;
                userList.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching users:', error));
}

// Chama a função ao carregar a lista de usuários
document.addEventListener('DOMContentLoaded', atualizarLista);