package CamadaDTO;

public class loginDTO {

    private String gmail, usuario, nome, senha;

    public loginDTO(String gmail, String usuario, String nome, String senha) {
        this.gmail = gmail;
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
    }
    
    public loginDTO() {
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
