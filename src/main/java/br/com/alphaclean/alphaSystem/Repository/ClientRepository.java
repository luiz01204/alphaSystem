package br.com.alphaclean.alphaSystem.Repository;

import br.com.alphaclean.alphaSystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
