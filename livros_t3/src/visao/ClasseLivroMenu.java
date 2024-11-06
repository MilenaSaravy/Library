package visao;

import dominio.ClasseLivros;
import servicio.ClasseLivroServicio;

public class ClasseLivroMenu extends BaseMenuLivros {

    private final ClasseLivroServicio srv;

    public ClasseLivroMenu() {
        super();
        this.srv = new ClasseLivroServicio();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            Util.LimparConsole();
            System.out.println("Cadastro de Livros");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando Livros:");
        for (ClasseLivros cp : srv.Navegar()) {
            this.ImprimirPorLinha(cp);
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        System.out.println("Localizando");
        System.out.print("Informe o código do Livro: ");
        int cod = this.scanner.nextInt();
        ClasseLivros cp = this.srv.Ler(cod);
        if (cp != null) {
            this.ImprimirPorLinha(cp);
        } else {
            System.out.println("Problema - Livro não encontrado");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando");

        String titulo = "";
        boolean tituloValido = false;
        String autor = "";
        boolean autorValido = false;
        String isbn = "";
        boolean isbnValido = false;
        int anoPublicacao = 0;
        boolean anoValido = false;

        while (!tituloValido) {
            System.out.print("Informe o Titulo: ");
            titulo = this.scanner.nextLine().trim();

            if (titulo.isEmpty()) {
                System.out.println("O título não pode ser vazio. Tente novamente.");
            } else {
                tituloValido = true;
            }
        }

        while (!autorValido) {
            System.out.print("Informe o Autor: ");
            autor = this.scanner.nextLine().trim();

            if (autor.isEmpty()) {
                System.out.println("O autor não pode ser vazio. Tente novamente.");
            } else {
                autorValido = true;
            }
        }

        while (!isbnValido) {
            System.out.print("Informe o ISBN: ");
            isbn = this.scanner.nextLine().trim();

            if (isbn.isEmpty()) {
                System.out.println("O ISBN não pode ser vazio. Tente novamente.");
            } else {
                isbnValido = true;
            }
        }

        while (!anoValido) {
            System.out.print("Informe o Ano de Publicação: ");
            if (this.scanner.hasNextInt()) {
                anoPublicacao = this.scanner.nextInt();
                if (anoPublicacao > 0) {
                    anoValido = true;
                } else {
                    System.out.println("O ano de publicação deve ser maior que 0. Tente novamente.");
                }
            } else {
                System.out.println("Por favor, insira um ano válido.");
                this.scanner.next();
            }
        }

        ClasseLivros cp = new ClasseLivros();
        cp.setTitulo(titulo);
        cp.setAutor(autor);
        cp.setISBN(isbn);
        cp.setAnoPublicacao(anoPublicacao);

        if (this.srv.Adicionar(cp) != null) {
            System.out.println("Livro adicionado com sucesso");
        } else {
            System.out.println("Problema - Erro ao adicionar Livro");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("Atualizando");
        System.out.print("Informe o código do Livro: ");
        int cod = this.scanner.nextInt();
        ClasseLivros cp = this.srv.Ler(cod);
        if (cp != null) {
            System.out.print("Informe o novo Titulo: ");
            String titulo = this.scanner.next();
            cp.setTitulo(titulo);
            if (this.srv.Editar(cp) != null) {
                System.out.println("Alteração realizada com sucesso");
            } else {
                System.out.println("Problema - alteração não foi realizada");
            }
        } else {
            System.out.println("Problema - Livro não encontrado");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("Removendo");
        System.out.print("Informe o código do Livro: ");
        int cod = this.scanner.nextInt();
        ClasseLivros cp = this.srv.Ler(cod);
        if (cp != null) {
            if (this.srv.Remover(cod) != null) {
                System.out.println("Livro excluído com sucesso");
            } else {
                System.out.println("Problema - Livro não foi excluído");
            }
        } else {
            System.out.println("Problema - Livro não encontrado");
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    private void ImprimirPorLinha(ClasseLivros cp) {
        System.out.println("Código: " + cp.getCodigo() + " | Título: " + cp.getTitulo() + " | Autor: " + cp.getAutor() + " | ISBN: " + cp.getISBN() + " | Ano: " + cp.getAnoPublicacao());
    }
}
