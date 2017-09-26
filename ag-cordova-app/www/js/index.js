//repositório
var rep = []

//minha representação de uma estrutura de objeto
var Aluno = function(c, n, e){
    this.cpf = c
    this.nome = n
    this.endereco = e
}

//representa as regras da visão
var app = {
    //salvar
    save: function(cpf, nome, endereco) {
        a = new Aluno(cpf, nome, endereco)
        rep.push(a)
    },
    //listar
    list: function(){
        return rep
    }
};