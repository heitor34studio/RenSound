package br.com.alura.RenSound.repository;

import br.com.alura.RenSound.model.Artista;
import br.com.alura.RenSound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SingerRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nomeArtista%")
    List<Musica> encontrarMusicasPorArtista(String nomeArtista);
}
