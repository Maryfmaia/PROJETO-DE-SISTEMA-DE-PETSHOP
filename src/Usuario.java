import java.time.LocalDate;
import java.util.regex.Pattern;

public class Usuario {
    private final int id;
    private final String cpf;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    private LocalDate dataNascimento;

    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Usuario(int id, String cpf, String nome, String email,
                   String senha, String telefone, String endereco, LocalDate dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setTelefone(telefone);
        setEndereco(endereco);
        setDataNascimento(dataNascimento);
    }

    /**
     * Autentica o usuário comparando email e senha.
     * @param emailEntrada Email informado
     * @param senhaEntrada Senha informada
     * @return true se autenticação for bem sucedida
     */
    public boolean autenticar(String emailEntrada, String senhaEntrada) {
        return this.email.equals(emailEntrada) && this.senha.equals(senhaEntrada);
    }

    public void alterarEmail(String novoEmail) {
        setEmail(novoEmail);
    }

    public void alterarSenha(String senhaAtual, String novaSenha) {
        if (!this.senha.equals(senhaAtual)) {
            throw new IllegalArgumentException("Senha atual incorreta.");
        }
        setSenha(novaSenha);
    }

    public void alterarTelefone(String novoTelefone) {
        setTelefone(novoTelefone);
    }

    public void alterarEndereco(String novoEndereco) {
        setEndereco(novoEndereco);
    }

    @Override
    public String toString() {
        return String.format("id=%d, nome=%s, email=%s, telefone=%s, endereco=%s, dataNascimento=%s", 
                id, nome, email, telefone, endereco, dataNascimento);
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    private void setSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter ao menos 6 caracteres.");
        }
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().length() < 8) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = telefone.trim();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio.");
        }
        this.endereco = endereco.trim();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        this.dataNascimento = dataNascimento;
    }
}