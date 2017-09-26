
var rep = []

var Aluno = function(c, n, e){
    this.cpf = c
    this.nome = n
    this.endereco = e
}

var app = {
    save: function(cpf, nome, endereco) {
        a = new Aluno(cpf, nome, endereco)
        rep.push(a)
    },
    list: function(){
        return rep
    }
};