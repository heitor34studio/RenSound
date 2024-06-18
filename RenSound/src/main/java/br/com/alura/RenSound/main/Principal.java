package br.com.alura.RenSound.main;

import br.com.alura.RenSound.model.Artista;
import br.com.alura.RenSound.model.Musica;
import br.com.alura.RenSound.repository.SingerRepository;

import java.util.*;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final SingerRepository repositorio;

    public Principal(SingerRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """ 
                    *** RenSound Músicas ***
                    
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Insira o nome do(a) Artista dono(a) das músicas:");
        var nomeArtista = leitura.nextLine();
        List<Musica> musicas = repositorio.encontrarMusicasPorArtista(nomeArtista);
        musicas.forEach(m -> System.out.println(m.getArtista().getNome() + "- " +m.getTitulo()));
    }

    private void listarMusicas() {
        List<Artista> artistasLista = repositorio.findAll();
        artistasLista.forEach(a -> a.getMusicas().forEach(m -> System.out.println(m.getArtista().getNome()
        + "- "+ m.getTitulo())));
    }

    private void cadastrarMusicas() {
        List<Musica> musicasLista = new ArrayList<>();
        System.out.println("Insira o nome do(a) Artista dono(a) da música:");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);
        if (artista.isPresent()) {
            Artista artistaEncontrado = artista.get();
            var opcaoContinuar = "S";
            while (opcaoContinuar.equalsIgnoreCase("s")) {
                System.out.println("Insira o nome da música do(a) artista " +
                        artistaEncontrado.getNome() + ":");
                var musicaDoArtista = leitura.nextLine();
                Musica musica = new Musica(musicaDoArtista, artistaEncontrado);
                musicasLista.add(musica);
                System.out.println("Quer cadastrar outra música? (S/N)");
                opcaoContinuar = leitura.nextLine();
            }
            artistaEncontrado.setMusicas(musicasLista);
            repositorio.save(artistaEncontrado);
        } else {
            System.out.println("Artista não encontrado(a). Cadastre ele primeiro com a opção 1.");
        }
    }

    private void cadastrarArtistas() {
        var opcaoContinuar = "S";
        while (opcaoContinuar.equalsIgnoreCase("s")) {
            System.out.println("Insira o nome do(a) Artista:");
            var nomeArtista = leitura.nextLine();
            System.out.println("Informe o tipo desse artista: (solo, dupla, ou banda)");
            var tipoArtista = leitura.nextLine();
            Artista artista = new Artista(nomeArtista, tipoArtista);
            repositorio.save(artista);
            System.out.println("Quer cadastrar outro artista? (S/N)");
            opcaoContinuar = leitura.nextLine();
        }
    }
}