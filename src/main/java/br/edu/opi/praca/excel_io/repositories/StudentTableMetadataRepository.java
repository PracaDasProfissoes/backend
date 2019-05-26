package br.edu.opi.praca.excel_io.repositories;

import br.edu.opi.praca.excel_io.models.StudentTableMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTableMetadataRepository extends JpaRepository<StudentTableMetadata, Long> {

}
